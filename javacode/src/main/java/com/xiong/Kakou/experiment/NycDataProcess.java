package com.xiong.Kakou.experiment;

import com.xiong.Kakou.entity.NycTaxiModel;
import com.xiong.Kakou.service.BeijingTaxiService;
import com.xiong.Kakou.util.CSVUtil;
import com.xiong.Kakou.util.DateUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/10/7 13:33
 * @description：
 * @modified By：
 * @version: $
 */
public class NycDataProcess {

    private static BeijingTaxiService service = new BeijingTaxiService();
    private static final String format = "yyyy-MM-dd HH:mm:ss";


    public static void main(String[] args) throws Exception {
        extractOD_1day();
    }

    private static void extractOD_1day() throws Exception {
        String filePath = "F:\\1毕业论文相关\\论文实验\\OD矩阵预测\\nyc实验\\nyc_od\\";

        Date curTime = DateUtils.strToDate("2016-01-19 00:00:00", format);
        Date end = DateUtils.strToDate("2016-07-00 00:00:00", format);
        List<String[]> list = new ArrayList<>();

        while (curTime.compareTo(end) < 0) {

            Date nextTime = DateUtils.addOrSubDayByDate(curTime, 1);

            String startTime = DateUtils.dateToStr(curTime, format);
            String endTime;
            String timeStramp = startTime.substring(0, 10);
            endTime = DateUtils.dateToStr(DateUtils.addOrSubDayByDateStr(startTime, 1, format), format);

            // matrix 52 * 52
            for (int j = 1; j <= 52; j++) {
                for (int k = 1; k <= 52; k++) {
                    NycTaxiModel model = new NycTaxiModel(startTime, endTime, j, k);

                    int count = service.selectCountByTime(model);

                    list.add(new String[]{j + "", k + "", timeStramp, count + ""});

                }
            }

            System.out.println("od 信息：" + DateUtils.dateToStr(curTime, format) + " 生成完毕");
            curTime = nextTime;

        }

        CSVUtil.createCSV(list, filePath + "nyc_steps_1day_all.csv", new String[]{"from", "to", "time_gap", "count"});
        System.out.println("写入成功");


    }


    private static void extractOD_1hour() throws Exception {
        String filePath = "F:\\1毕业论文相关\\论文实验\\OD矩阵预测\\nyc实验\\nyc_od\\";

        Date curTime = DateUtils.strToDate("2016-01-19 00:00:00", format);
        Date end = DateUtils.strToDate("2016-02-20 00:00:00", format);
        List<String[]> list = new ArrayList<>();

        while (curTime.compareTo(end) < 0) {

            Date nextTime = DateUtils.addOrSubHourByDate(curTime, 1);

            String startTime = DateUtils.dateToStr(curTime, format);
            String endTime;

            endTime = DateUtils.dateToStr(DateUtils.addOrSubHourByDateStr(startTime, 1, format), format);

            // matrix 52 * 52
            for (int j = 1; j <= 52; j++) {
                for (int k = 1; k <= 52; k++) {
                    NycTaxiModel model = new NycTaxiModel(startTime, endTime, j, k);

                    int count = service.selectCountByTime(model);

                    list.add(new String[]{j + "", k + "", startTime, count + ""});

                }
            }

            System.out.println("od 信息：" + DateUtils.dateToStr(curTime, format) + " 生成完毕");
            curTime = nextTime;

        }

        CSVUtil.createCSV(list, filePath + "nyc_steps_1hour_1month.csv", new String[]{"from", "to", "time_gap", "count"});
        System.out.println("写入成功");


    }


    private static void extractOD() throws Exception {

        List<String[]> list00_07 = new ArrayList<>();
        List<String[]> list07_09 = new ArrayList<>();
        List<String[]> list09_13 = new ArrayList<>();
        List<String[]> list13_17 = new ArrayList<>();
        List<String[]> list17_20 = new ArrayList<>();
        List<String[]> list20_24 = new ArrayList<>();

        String filePath = "F:\\1毕业论文相关\\论文实验\\OD矩阵预测\\nyc实验\\nyc_od\\";

        Date curTime = DateUtils.strToDate("2016-01-19 00:00:00", format);
        Date end = DateUtils.strToDate("2016-07-00 00:00:00", format);

        while (curTime.compareTo(end) < 0) {

            Date nextTime = DateUtils.addOrSubDayByDate(curTime, 1);

            int[] arr = {7, 2, 4, 4, 3, 4};
            // String[] name = {"00_07", "07_09","09_13","13_17","17_20","20_24"};
            String startTime = DateUtils.dateToStr(curTime, format);
            String endTime;
            String timegap = startTime.substring(0, 10);

            for (int i = 0; i < arr.length; i++) {
                List<String[]> list = new ArrayList<>();
                switch (i) {
                    case 0:
                        list = list00_07;
                        break;
                    case 1:
                        list = list07_09;
                        break;
                    case 2:
                        list = list09_13;
                        break;
                    case 3:
                        list = list13_17;
                        break;
                    case 4:
                        list = list17_20;
                        break;
                    case 5:
                        list = list20_24;
                        break;
                    default:
                        break;
                }


                endTime = DateUtils.dateToStr(DateUtils.addOrSubHourByDateStr(startTime, arr[i], format), format);

                // matrix 52 * 52
                for (int j = 1; j <= 52; j++) {
                    for (int k = 1; k <= 52; k++) {
                        NycTaxiModel model = new NycTaxiModel(startTime, endTime, j, k);

                        int count = service.selectCountByTime(model);

                        list.add(new String[]{j + "", k + "", timegap, count + ""});

                    }
                }
                startTime = endTime;

            }
            System.out.println("od 信息：" + DateUtils.dateToStr(curTime, format) + " 生成完毕");
            curTime = nextTime;

        }


        CSVUtil.createCSV(list00_07, filePath + "nyc00_07.csv", new String[]{"from", "to", "time_gap", "count"});
        CSVUtil.createCSV(list07_09, filePath + "nyc07_09.csv", new String[]{"from", "to", "time_gap", "count"});
        CSVUtil.createCSV(list09_13, filePath + "nyc09_13.csv", new String[]{"from", "to", "time_gap", "count"});
        CSVUtil.createCSV(list13_17, filePath + "nyc13_17.csv", new String[]{"from", "to", "time_gap", "count"});
        CSVUtil.createCSV(list17_20, filePath + "nyc17_20.csv", new String[]{"from", "to", "time_gap", "count"});
        CSVUtil.createCSV(list20_24, filePath + "nyc20_24.csv", new String[]{"from", "to", "time_gap", "count"});
        System.out.println("写入成功");
    }
}
