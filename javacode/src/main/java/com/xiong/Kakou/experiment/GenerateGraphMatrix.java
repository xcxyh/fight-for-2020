package com.xiong.Kakou.experiment;

import com.xiong.Kakou.entity.Graph;
import com.xiong.Kakou.entity.KakouPointModel;
import com.xiong.Kakou.entity.LinkModel;
import com.xiong.Kakou.service.LinkService;
import com.xiong.Kakou.service.PointServcie;
import com.xiong.Kakou.util.GraphGenerator;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/3/6 11:16
 * @description：
 * @modified By：
 * @version: $
 */
public class GenerateGraphMatrix {

    static PointServcie pointServcie = new PointServcie();

    static LinkService linkService = new LinkService();

    public static void main(String[] args) {
        //生成 矩阵  weight(link长度)  from(卡口起点)  to(卡口终点)
        Integer[][] matrix =generatorMatrix();
       Graph graph = GraphGenerator.creatGraph(matrix);
        System.out.println(graph.toString());
    }

    /**
     * @author: xiongcong
     * @Date: 2020/3/6 12:10
     * @Description: 生成矩阵
     */
    public static Integer[][] generatorMatrix() {
        Integer[][] matrix;
        //取出所有卡口stationid 作为起点
        List<KakouPointModel> station = pointServcie.selectAllStation();
        int size = station.size();
        List<LinkModel> allLink = linkService.selectAllLink();

        //建立linkid 和 length的对应关系
        Map<String, String> linkMap = new HashMap<>();
        for (int i = 0; i < allLink.size(); i++) {
            LinkModel linkModel = allLink.get(i);
            linkMap.put(linkModel.getID_Link(), linkModel.getLink_length().toString());
        }

        //建立stationID 和 点ID 的对应关系
        Map<String, Integer> stationMap = new HashMap<>();
        for (int i = 0; i < station.size(); i++) {
            KakouPointModel point = station.get(i);
            stationMap.put(point.getID_Station(),i);
        }


        //矩阵初始化
        matrix = new Integer[130][3];
        int k = 0;
        for (int i = 0; i < size; i++) {

            KakouPointModel next = station.get(i);
            String start_stationID = next.getID_Station();
            String linkID = next.getID_Link();
            //根据起点连接的link 去寻找 终点
            List<KakouPointModel> point = pointServcie.selectByIDLink(linkID);

            if (point.size() > 1) {
                for (int j = 0; j < point.size(); j++) {
                    String end_stationID = point.get(j).getID_Station();
                    if (!end_stationID.equals(start_stationID)) {
                        //取出link的长度length 作为权重
                        matrix[k][0] =(int) Double.parseDouble(linkMap.get(linkID)); // weight
                        matrix[k][1] = stationMap.get(start_stationID); //from
                        matrix[k][2] =  stationMap.get(end_stationID); //to
                        k++;
                    }
                }

            }
        }
        //生成Matrix[][3]
        return matrix;
    }

}
