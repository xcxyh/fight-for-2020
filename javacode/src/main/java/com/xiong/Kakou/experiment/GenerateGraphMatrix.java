package com.xiong.Kakou.experiment;

import com.xiong.Kakou.entity.*;
import com.xiong.Kakou.service.CarService;
import com.xiong.Kakou.service.ChainService;
import com.xiong.Kakou.service.LinkService;
import com.xiong.Kakou.util.*;

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
    //处理节点 新建map 存储 node 和 编号的对应关系  K nodeid  V  i
    static Map<String, Integer> nodeMap = new HashMap<>();

    private static final String FORMAT = "yyyy-MM-dd HH:mm:ss";
    //存储 node 和  卡口编号之间的关系 vdmap    K vd  V  nodeid
    static Map<String, String> vdmap = new HashMap<>();

    public static void main(String[] args) throws Exception {

        //使用 最短路径算法 进行 出行链划分
        separateChain();

        //划分好的出行链分配OD矩阵 是 node 和node 之间的 OD 矩阵

        //将OD 矩阵中node node 经过的link 记录下link上的流量

        //将 link上的流量和 OD 矩阵分配出的流量进行修正和补全 ？

        //得到最终的node 到 node 的OD 矩阵  然后通过聚类 得到交通小区之间的OD 矩阵 ？

        // 将 OD 估计的结果 和 link上的流量进行 对比分析

    }
    /**
     *  @author: xiongcong
     *  @Date: 2020/3/15 16:16
     *  @Description:  使用 最短路径算法 进行 出行链划分
     */
    private static void separateChain() throws ParseException {
        //生成 矩阵  weight(link长度)  from(from_node)  to(to_node)
        EdgeWeightedDiGraph<String> graph = generatorGraph();

        //取出对应关系
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
                    flag = isoneChain(interval, node1, node2, graph);
                }
                if (flag) {
                    if (j == 0) {
                        node1.setStatus("S");
                    }
                    node2.setStatus("P");
                } else {
                    node1.setStatus("E");
                    node2.setStatus("S");
                }
                //如果到达最后
                if (j == chainModels.size() - 2) {
                    node2.setStatus("E");
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
    private static boolean isoneChain(int interval, ChainModel node1, ChainModel node2, EdgeWeightedDiGraph<String> graph) {
        Dijkstra dijkstra = new Dijkstra(graph);//新建一个dj
        String vd1 = node1.getSbbh();
        String vd2 = node2.getSbbh();

        Integer from = nodeMap.get(vdmap.get(vd1));
        Integer to = nodeMap.get(vdmap.get(vd2));

        //如果 from 或者 to 为 null  则代表不在图中 跳过 直接返回true
        if (from == null || to == null) {
            return true;
        }
        //求解最短路径
        Iterable<DiEdge> edges = dijkstra.fromTopath(from, to);

        if (edges == null) {
            return true;
        }

        Iterator<DiEdge> it = edges.iterator();
        Double length = 0.0;
        while (it.hasNext()) {
            length += it.next().weight();
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
        int[][] edges;
        List<String> vertexInfo;
        int[] weight;
        List<LinkModel> allLink = linkService.selectAllLink();
        int size = allLink.size();
        //初始化
        edges = new int[size][2];
        weight = new int[size];
        vertexInfo = new ArrayList<>();

        int k = 0;
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
        }
        //将编号 添加到 vertexInfo
        for (int i = 0; i < k; i++) {
            vertexInfo.add(i + "");
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


        EdgeWeightedDiGraph<String> graph = new EdgeWeightedDiGraph<>(vertexInfo, edges, weight);

        System.out.println("该图的邻接表为\n" + graph);
        System.out.println("该图的所有边：" + graph.edges());
        return graph;
    }

}
