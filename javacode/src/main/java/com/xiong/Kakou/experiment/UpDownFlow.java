package com.xiong.Kakou.experiment;

import com.xiong.Kakou.entity.FuseLinkModel;
import com.xiong.Kakou.service.FuseLinkService;
import com.xiong.Kakou.util.CSVUtil;
import com.xiong.Kakou.util.DateUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/12/19 15:17
 * @description：
 * @modified By：
 * @version: $
 */
public class UpDownFlow {

    static FuseLinkService service = new FuseLinkService();
    static String format = "yyyy-MM-dd HH:mm:ss";
    static int[] links = new int[]{
            14197, 14198, 14199, 14222, 14313, 14314, 14315,
            14316, 14317, 14318, 14319, 14322, 14388, 14397,
            14742, 14743, 32433, 32434, 32344, 14195};

    public static void main(String[] args) throws Exception {

        String[] headers = new String[]{"14394",
                "14195", "14197", "14198", "14199", "14200", "14222",
                "14223", "14310", "14313", "14314", "14315", "14316",
                "14317", "14318", "14319", "14322", "14388", "14390",
                "14392", "14393", "14395", "14397", "14398", "14742",
                "14743", "32433", "32434", "14400", "14405", "32344"};

        List<String[]> dataList = new ArrayList<>();
        FuseLinkModel model = new FuseLinkModel();


        Date curTime = DateUtils.strToDate("2020-11-27 00:00:00", format);
        Date end = DateUtils.strToDate("2020-12-04 00:00:00", format);

        while (curTime.compareTo(end) < 0) {

            Date nextTime = DateUtils.addOrSubMinuteByDate(curTime, 5);

            String curTimeStr = DateUtils.dateToStr(curTime, format) ;

            model.setStartTime(curTimeStr);
            String[] temp = new String[headers.length];
            int j = 0;
            for (String link : headers) {
                model.setID_Link(link);
                String val = service.selectValByModel(model);
                temp[j++] = val;
            }
            dataList.add(temp);
            System.out.println(curTimeStr);
            curTime = nextTime;
        }



        Boolean isDone = CSVUtil.createCSV(dataList, "F:\\1毕业论文相关\\论文实验\\交通流预测\\wuhan2704.csv", headers);
        System.out.println(isDone);
    }

//    private void notuse() {
//        Random random = new Random();
//        random.setSeed(100256);
//        int count = 0;
//        for (int link : links) {
//
//            List<FuseLinkModel> list = service.selectLinkByID(String.valueOf(link));
//
//            for (FuseLinkModel model : list) {
//
//                String time = model.getStartTime();
//
//                String newTime = DateUtils.dateToStr(DateUtils.addOrSubDayByDateStr(time, -7, format), format);
//
//                int valcount = Integer.valueOf(model.getVehicleCount());
//
//                if (valcount <= 0) {
//                    valcount = 1;
//                }
//
//                int number = random.nextInt(valcount) + 1 - valcount / 2;
//
//                int val = valcount + number;
//
//                if (val < 0) {
//                    val = 0;
//                }
//                model.setStartTime(newTime);
//                model.setVehicleCount(String.valueOf(val));
//
//                service.instertIntoNew(model);
//            }
//            count++;
//            System.out.println("get the " + count + ": " + link + "  ok");
//        }
//    }


}
