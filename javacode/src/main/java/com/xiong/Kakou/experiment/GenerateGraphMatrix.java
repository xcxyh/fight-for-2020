package com.xiong.Kakou.experiment;

import com.xiong.Kakou.entity.*;
import com.xiong.Kakou.service.CarService;
import com.xiong.Kakou.service.ChainService;
import com.xiong.Kakou.service.LinkService;
import com.xiong.Kakou.service.PostgresEmmeService;
import com.xiong.Kakou.util.*;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.*;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/3/6 11:16
 * @description：
 * @modified By：
 * @version: $
 */
public class GenerateGraphMatrix {

    static CarService carService = new CarService();

    static LinkService linkService = new LinkService();

    static ChainService chainService = new ChainService();

    static PostgresEmmeService postgresEmmeService = new PostgresEmmeService();

    //处理节点 新建map 存储 node 和 编号的对应关系  K nodeid  V  i
    static Map<String, Integer> nodeMap = new HashMap<>();



    //编号 从 1 开始到 node_size  卡口station 从 1 开始编号
    static Map<String, Integer> stationMap = new HashMap<>();

    private static final String FORMAT = "yyyy-MM-dd HH:mm:ss";
    //存储 node 和  卡口编号之间的关系 vdmap    K vd  V  nodeid
    static Map<String, String> vdmap = new HashMap<>();

    // 存储一个点的经纬度
    static Map<Integer, double[]>  latLonMap = new HashMap<>();

    public static void main(String[] args) throws Exception {
        //取出对应关系

        //使用 最短路径算法 进行 出行链划分
        separateChain();
        System.out.println("-----出行链划分完毕-----");
        //划分好的出行链分配OD矩阵 是 node 和node 之间的 OD 矩阵

        int[][] od_matrix = generateOD();
        System.out.println("-----出行矩阵OD生成完毕-----");

        //交通小区 聚类

        //AreaCluster 文件完成

        //聚类 得到交通小区之间的OD 矩阵
        String filepath = "F:\\OD矩阵资料\\实验数据\\ODMAtrix_xq.txt";
        ArrayList<VDToNodeModel> vdtonode = carService.mapvdtonode();
        Map<Integer, Integer> clusterMap = new HashMap<>();

        for (VDToNodeModel model : vdtonode) {
            clusterMap.put(model.getFID(), Integer.parseInt(model.getXqbh()));
        }

        int[][] xqbh_matrix = new int[21][21];

        //行列初始化
        for (int i = 1; i < xqbh_matrix.length; i++) {
            xqbh_matrix[i][0] = i;
        }
        for (int i = 1; i < xqbh_matrix[0].length; i++) {
            xqbh_matrix[0][i] = i;
        }

        for (int i = 1; i < od_matrix.length; i++) {
            for (int j = 1; j < od_matrix[0].length; j++) {
                xqbh_matrix[clusterMap.get(i)][clusterMap.get(j)] += od_matrix[i][j];
            }
        }

        List<String> result = new ArrayList<>();
        for (int i = 0; i < xqbh_matrix.length; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < xqbh_matrix[0].length; j++) {
                int temp = xqbh_matrix[i][j];
                stringBuilder.append(temp + " ");
            }
            result.add(stringBuilder.toString());
        }
        //交通小区间的OD 矩阵为 xqbh_matrix
        TXTUtil.writeTxt(filepath, result);

        // 将 OD 估计的结果 和 link上的流量进行 对比分析

    }

    /**
     * @author: xiongcong
     * @Date: 2020/3/16 14:17
     * @Description: 划分好的出行链分配OD矩阵 是 卡口station 和 卡口station 之间的 OD 矩阵
     */
    public static int[][] generateOD() {
        //输出到文件
        String filepath = "F:\\OD矩阵资料\\实验数据\\ODMAtrix.txt";
        ArrayList<VDToNodeModel> vdtonode = carService.mapvdtonode();
        int node_size = vdtonode.size();
        for (int i = 0; i < node_size; i++) {
            stationMap.put(vdtonode.get(i).getVd(), vdtonode.get(i).getFID());
        }

        int[][] od_matrix = new int[node_size + 1][node_size + 1];

        //行 列 初始化
        for (int i = 1; i < od_matrix.length; i++) {
            od_matrix[i][0] = i;
        }
        for (int i = 1; i < od_matrix[0].length; i++) {
            od_matrix[0][i] = i;
        }

        String carid = "Car0";
        for (int i = 1; i <= 22206; i++) {
            String hphm = carid + i;
            ArrayList<ChainModel> chainModels = chainService.selectChainByhp(hphm);
            int from_node = -1;
            int to_node = -1;
            for (int j = 0; j < chainModels.size(); j++) {
                ChainModel temp = chainModels.get(j);

                if ("O".equals(temp.getStatus())) {
                    from_node = stationMap.get(temp.getSbbh());
                }
                if ("D".equals(temp.getStatus())) {

                    to_node = stationMap.get(temp.getSbbh());
                    if (from_node == -1) {  // 如果单独 则 既是O 点也是D点
                        from_node = to_node;
                    }
                    od_matrix[from_node][to_node] += 1;
                    from_node = -1; // 避免 O D D 的清况
                    to_node = -1;
                }
            }
            System.out.println("车辆 " + i + " 处理完");
        }
        int sum = 0;
        List<String> result = new ArrayList<>();
        for (int i = 0; i < od_matrix.length; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < od_matrix[0].length; j++) {
                int temp = od_matrix[i][j];
                if (i != 0 && j != 0) {
                    sum += temp;
                }
                stringBuilder.append(temp + " ");
            }
            result.add(stringBuilder.toString());
        }
        System.out.println("该时段内该区域总OD对的数量为：" + sum);
        TXTUtil.writeTxt(filepath, result);
        return od_matrix;
    }

    /**
     * @author: xiongcong
     * @Date: 2020/3/15 16:16
     * @Description: 使用 最短路径算法 进行 出行链划分, 修正后 O 与 D 的误差为 1.05%
     */
    private static void separateChain() throws ParseException {

        //生成 矩阵  weight(link长度)  from(from_node)  to(to_node)
        EdgeWeightedDiGraph<String> graph = generatorGraph();

        ArrayList<VDToNodeModel> vdtonode = carService.mapvdtonode();
        for (VDToNodeModel model : vdtonode) {
            vdmap.put(model.getVd(), model.getNode());
        }
        //读取车辆初步出行链数据  时间  7：00 到 9 ：00

        String carid = "Car0";

        for (int i = 1; i <= 22206; i++) {
            String hphm = carid + i;
            ArrayList<ChainModel> chainModels = chainService.selectChainByhp(hphm);

            //划分该辆车的出行链
            for (int j = 0; j < chainModels.size() - 1; j++) {
                ChainModel node1 = chainModels.get(j);
                ChainModel node2 = chainModels.get(j + 1);
                // 比较时间
                long time1 = DateUtils.convertDateStrToMillis(node1.getGcsj(), FORMAT);
                long time2 = DateUtils.convertDateStrToMillis(node2.getGcsj(), FORMAT);

                int interval = (int) (time2 - time1) / 1000; //单位为秒

                boolean flag = true; //true 代表 不分开
                //当间隔时间小于1分钟时 不用 运行dj算法 默认属于同一条链上的节点
                if (interval > 60) {
                    flag = isoneChain(interval, node1, node2, graph, latLonMap);
                }
                int reset = 0;
                if (flag) {
                    if (j == 0) {
                        node1.setStatus("O");
                    }
                    node2.setStatus("M");
                } else {
                    if (j == 0) {
                        node1.setStatus("X");
                        node2.setStatus("O");
                    }
                    if ("M".equals(node1.getStatus())) {
                        //此时 node1 和node2 分别 属于不同的出行链
                        node1.setStatus("D");
                        node2.setStatus("O");
                    } else if ("O".equals(node1.getStatus())) {
                        node1.setStatus("X");
                        node2.setStatus("O");
                    }


                }
                //如果到达最后
                if (j == chainModels.size() - 2) {
                    if ("D".equals(node1.getStatus()) || "X".equals(node1.getStatus())) {
                        node2.setStatus("X");
                    } else {
                        node2.setStatus("D");
                    }
                }
                chainService.updateStatus(node1);
                chainService.updateStatus(node2);
            }
            //
            System.out.println("第 " + i + " 辆车的出行链划分完毕");
        }
    }

    /**
     * @author: xiongcong
     * @Date: 2020/3/15 14:39
     * @Description: 通过 最短路径算法和 车辆速度 40 km /h -> 11.11 m/s length 单位为 m  进行划分
     */
    private static boolean isoneChain(int interval, ChainModel node1, ChainModel node2, EdgeWeightedDiGraph<String> graph,Map<Integer, double[]> latlonMap) {


        Dijkstra dijkstra = new Dijkstra(graph, latlonMap);//新建一个dj
        String vd1 = node1.getSbbh();
        String vd2 = node2.getSbbh();
        // 通过 卡口 编号 得到  node 编号，  然后 得到 dijstra 里面的 编号
        Integer from = nodeMap.get(vdmap.get(vd1)); //
        Integer to = nodeMap.get(vdmap.get(vd2));

        //如果 from 或者 to 为 null  则代表不在图中 跳过 直接返回true
        if (from == null || to == null) {
            return true;
        }

        //得到坐标
        double[] latlon1 = latlonMap.get(from);
        double[] latlon2 = latlonMap.get(to);

        // 得到 xc yc range_x rang_y
        double[] range = PointUtil.getRange(latlon1[0], latlon1[1], latlon2[0], latlon2[1]);

        //求解最短路径
        double length = dijkstra.distTo(from, to, range);
        if (length == -1) {
            return true; // 不可达 不存在最短路径
        }
        double time = length / 11.11;
        //间隔大于 最短行程时间的 2倍 分开
        if (interval > time * 2) {
            return false;
        }
        return true;
    }

    /**
     * @author: xiongcong
     * @Date: 2020/3/15 9:27
     * @Description: 初步生成出行链
     */
    public void generateChain() throws Exception {
        String filePath = "F:\\OD矩阵资料\\实验数据\\chuxinglian.csv";
        String[] csvHeaders = {"hphm", "gcsj", "sbbh", "CDBH", "longitude", "latitude"};

        CarService service = new CarService();
        ArrayList<String> result = service.selectHaopai();
        Iterator<String> it = result.iterator();
        List<String[]> csvList = new ArrayList<>();
        int carNum = 0;
        while (it.hasNext()) {
            String hphm = it.next();
            ArrayList<KakouCarModel> list = service.selectByHphm(hphm);
            if (list.size() > 1) {
                carNum++;
                for (int i = 0; i < list.size(); i++) {
                    KakouCarModel model = list.get(i);
                    model.setHphm("Car0" + carNum);
                    String[] temp = new String[6];

                    temp[0] = model.getHphm();
                    temp[1] = model.getGcsj();
                    temp[2] = model.getSbbh();
                    temp[3] = model.getCDBH();
                    temp[4] = model.getLongitude();
                    temp[5] = model.getLatitude();
                    csvList.add(temp);
                }
            }
        }
        //写入csv
        CSVUtil.createCSV(csvList, filePath, csvHeaders);
        System.out.println("生成初步出行链");


    }

    /**
     * @author: xiongcong
     * @Date: 2020/3/6 12:10
     * @Description: 生成graph
     */
    public static EdgeWeightedDiGraph<String> generatorGraph() {
        List<LinkModel> allLink = linkService.selectAllLink();
        int size = allLink.size();
        int[][] edges;
        int[] weight;
        //初始化
        edges = new int[size][2];
        weight = new int[size];


        int k = 0;  // 顶点 总数
        for (int i = 0; i < size; i++) {
            LinkModel linkModel = allLink.get(i);
            String node1 = linkModel.getFrom_node();
            String node2 = linkModel.getTo_node();

            if (nodeMap.get(node1) == null) {
                nodeMap.put(node1, k++);
            }
            if (nodeMap.get(node2) == null) {
                nodeMap.put(node2, k++);
            }
            double[] latlon1 =  getlatlon(node1);
            if (latlon1 != null){
                // 得到 图中 所有的 点 对应的 经纬度  key 为 dijstra 中的 id
                latLonMap.put(nodeMap.get(node1),latlon1);
            }
            double[] latlon2 =  getlatlon(node2);
            if (latlon2 != null){
                // 得到 图中 所有的 点 对应的 经纬度  key 为 dijstra 中的 id
                // todo 这里 nodeMap 大小为 804 latlonMap 大小为 758 有的点没对上
                latLonMap.put(nodeMap.get(node2),latlon2);

            }

        }

        //生成图  将node 转成 编号
        for (int i = 0; i < size; i++) {
            LinkModel linkModel = allLink.get(i);
            //取出link的长度length 作为权重
            float len = linkModel.getLink_length();
            weight[i] = (int) len; // weight
            edges[i][0] = nodeMap.get(linkModel.getFrom_node()); //from
            edges[i][1] = nodeMap.get(linkModel.getTo_node());  //to
        }


        EdgeWeightedDiGraph<String> graph = new EdgeWeightedDiGraph<>(k, edges, weight);

        System.out.println("该图的邻接表为\n" + graph);
        System.out.println("该图的所有边：" + graph.edges());
        return graph;
    }

    private static double[] getlatlon(String node){
        double[] res = null;
        Integer nodeid = Integer.parseInt(node);
        EmmeNodeModel emmeNode = postgresEmmeService.selectNodeByID(nodeid);
        if (emmeNode != null){
            String geom = emmeNode.getGeom();
            geom = geom.substring(6, geom.length() - 1);
            // todo 想办法 获得 点的经纬度
            String[] latlon = geom.split(" ");
            double lat = Double.parseDouble(latlon[1]); // 纬度在后面
            double lon = Double.parseDouble(latlon[0]);
            res = new double[]{lat,lon};
        }
        return res;
    }

}
