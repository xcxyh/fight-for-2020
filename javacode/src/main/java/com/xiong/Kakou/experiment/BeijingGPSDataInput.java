package com.xiong.Kakou.experiment;

import com.xiong.Kakou.entity.BeijingTaxiModel;
import com.xiong.Kakou.service.BeijingTaxiService;
import com.xiong.Kakou.util.TXTUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/10/3 14:58
 * @description：
 * @modified By：
 * @version: $
 */
public class BeijingGPSDataInput {

    private static BeijingTaxiService service = new BeijingTaxiService();

    public static void main(String[] args) {


        for (int i = 2; i <= 10357; i++) {
            String filePath = "F:\\1毕业论文相关\\论文实验\\OD矩阵预测\\数据集\\T-drive Taxi Trajectories\\release\\taxi_log_2008_by_id\\" + i + ".txt";

            List<String> sts = TXTUtil.readTxt(new File(filePath));

            List<BeijingTaxiModel> list = new ArrayList<>();
            for (String str : sts) {

                String[] strings = str.split(",");

                BeijingTaxiModel model = new BeijingTaxiModel(Integer.valueOf(strings[0]), strings[1], strings[2], strings[3]);

                list.add(model);
            }
            if (list.size() > 0) {
                int ret = service.batchInsert(list);
                System.out.println("插入结果： 第 " + i + "辆车轨迹导入 " + ret + "条");
            }

        }

    }

}