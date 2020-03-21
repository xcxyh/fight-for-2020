package com.xiong.Kakou.experiment;

import com.xiong.Kakou.util.CSVUtil;
import com.xiong.Kakou.util.K_means;

import java.util.*;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/3/20 11:14
 * @description：
 * @modified By：
 * @version: $
 */
public class AreaCluster {

    public static void main(String[] args) throws Exception {
        //初始化一个Kmean对象
        int num = 20; //需要分成的簇数量
        K_means k = new K_means(num);
        ArrayList<float[]> dataSet = new ArrayList<>();

        List<String[]> kakou = CSVUtil.readCSV("F:\\OD矩阵资料\\实验数据\\t_kakoucore.csv");

        for (String[] str : kakou) {
            float[][] point1 = new float[1][3];
            point1[0][0] = Float.parseFloat(str[4].trim());
            point1[0][1] = Float.parseFloat(str[5].trim());
            point1[0][2] = Float.parseFloat(str[0].trim()); //fid
            dataSet.add(point1[0]);
        }
        //设置原始数据集
        k.setDataSet(dataSet);
        //执行算法
        k.kmeans();
        //得到聚类结果
        ArrayList<ArrayList<float[]>> cluster = k.getCluster();
        //查看结果
        List<String[]>  result = new ArrayList<>();
        for (int i = 0; i < cluster.size(); i++) {
            List<String[]>  temp =  k.getNodeClusterMap(cluster.get(i),  (i+1) + "");
            result.addAll(temp);
        }
        CSVUtil.createCSV(result, "F:\\OD矩阵资料\\实验数据\\cluster.csv",new String[]{"FID","cluster"});
    }

}
