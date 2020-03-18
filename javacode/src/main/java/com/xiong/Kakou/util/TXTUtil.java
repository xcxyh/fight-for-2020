package com.xiong.Kakou.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ：xiongcong
 * @date ：Created in 2019/10/21 10:52
 * @description：
 * @modified By：
 * @version: $
 */
public class TXTUtil {

    public static void main(String[] args) {
        File file = new File("F:\\3D-GIS平台开发\\OD转换2019.11.20\\taz815.txt");
        String outputPath = "F:\\3D-GIS平台开发\\OD转换2019.11.20\\";
        List<String> list = readTxt(file);
        List<String> resultList = new ArrayList<>();

        String[] headers = {"<DYNAMEQ>","<VERSION_3.0>","<MATRIX_FILE>",
                "FORMAT:linear","VEH_CLASS","Car","DATA"};

        for (int i = 0; i <headers.length ; i++) {
                resultList.add(headers[i]);
        }
        resultList.add("08:00");
        resultList.add("09:00");
        resultList.add("SLICE");
        resultList.add("08:15");
        for (int i = 0; i < list.size(); i++) {
            StringBuilder sb = new StringBuilder();
            String[] strs = list.get(i).split(" ");
            int strs_size = strs.length;
            strs[strs_size-1]= Integer.parseInt(strs[strs_size-1])*4 +"";
            for (int j = 0; j <strs_size-1 ; j++) {
                sb.append(strs[j]);
                sb.append("\t");
            }
            sb.append(strs[strs_size-1]);
            resultList.add(sb.toString());
        }

        writeTxt(outputPath+"result.dqt", resultList);
    }

    /**
     *  @author: xiongcong
     *  @Date: 2019/10/21 11:58
     *  @Description: 读取txt文件 传入文件名  返回list
     */
    public static List<String> readTxt(File file) {

        List<String> list = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));//构造一个BufferedReader类来读取文件
            String s = null;
            while ((s = br.readLine()) != null) {//使用readLine方法，一次读一行
                list.add(s);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    /**
     *  @author: xiongcong
     *  @Date: 2019/10/21 11:58
     *  @Description: 写txt文件 传入输出路径  和 list
     */
    public static void writeTxt(String filePath,List<String> list) {
        FileWriter fwriter = null;
        try {

            //判断文件是否存在,存在则删除,然后创建新
            File tmp = new File(filePath);
            if (tmp.exists()) {
               tmp.delete();
            }

            // true表示不覆盖原来的内容，而是加到文件的后面。若要覆盖原来的内容，直接省略这个参数就好
            fwriter = new FileWriter(filePath, true);
            for (int i = 0; i < list.size(); i++) {
                fwriter.write(list.get(i));
                fwriter.write('\r'); // \r\n表示换行
                fwriter.write('\n');
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                fwriter.flush();
                fwriter.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
