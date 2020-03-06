package com.xiong.Kakou.util;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class CSVUtil {
    public static char separator = ',';
    public static void main(String[] args) throws Exception {
    }

    /**
     * 读取CSV文件
     * @param filePath:全路径名
     */
    public static List<String[]> readCSV(String filePath) throws Exception {
        CsvReader reader = null;
        List<String[]> dataList = new ArrayList<String[]>();
        try {
            //如果生产文件乱码，windows下用gbk，linux用UTF-8
            reader = new CsvReader(filePath, separator, Charset.forName("UTF-8"));

            // 读取表头
            reader.readHeaders();
            String[] headArray = reader.getHeaders();//获取标题
            // 逐条读取记录，直至读完
            while (reader.readRecord()) {
                String[] temp = new String[headArray.length];
                for (int i = 0; i < headArray.length; i++) {
                    temp[i]  = reader.get(headArray[i]);
                }
                dataList.add(temp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != reader) {
                reader.close();
            }
        }

        return dataList;
    }

    /**
     * 生成CSV文件
     * @param dataList:数据集
     * @param filePath:全路径名
     */
    public static boolean createCSV(List<String[]> dataList, String filePath,String[] csvHeaders ) throws Exception {
        boolean isSuccess = false;
        CsvWriter writer = null;
        FileOutputStream out = null;
        try {

            //判断文件是否存在,存在则删除,然后创建新文件
            File tmp = new File(filePath);
            if (tmp.exists()) {
              tmp.delete();
            }

            out = new FileOutputStream(filePath, true);
            //如果生产文件乱码，windows下用gbk，linux用UTF-8
            writer = new CsvWriter(out, separator, Charset.forName("UTF-8"));

            //写表头
            writer.writeRecord(csvHeaders);

            for (String[] strs : dataList) {
                writer.writeRecord(strs);
            }
            isSuccess = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != writer) {
                writer.close();
            }
            if (null != out) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return isSuccess;
    }

    //获取指定csv文件数据，存入二维数组并返回
    public static Double[][] getCsvDataNew(String filePath,int column_num) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader(new File(filePath)));
        String line = "";
        ArrayList<Double[]> lineList = new ArrayList<Double[]>();
        // Read a single line from the file until there are no more lines to read
        while((line = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(line, ","); // 以逗号作为分隔符
            Double[] currCol = new Double[column_num]; // Each currCol has 9 fields, so we need room for the 8 tokens.
            for(int i = 0; i < column_num; i++) { // For each token in the line that we've read:
                //先判断是否还有待读取数据，防止溢出
                if(st.hasMoreTokens()){
                    currCol[i]  = Double.parseDouble(st.nextToken());
                }

            }
            lineList.add(currCol);
        }

        Double[][] str = new Double[lineList.size()][column_num];
        for(int i = 0; i < lineList.size(); i++) {
            for(int j = 0; j < column_num; j++) {
                str[i][j] = lineList.get(i)[j];
                //System.out.println(str[i][x]);
            }
        }

        br.close();

        return str;
    }

    public static <T> void writeCSV(Double[][] dataSet, String csvFilePath, String[] csvHeaders)  {
        try {
            //判断文件是否存在,存在则删除,然后创建新表格
            File tmp = new File(csvFilePath);
            if (tmp.exists()) {
                if (tmp.delete()) {
                    //logger.info(csvFilePath + Constant.DUPLICATE_FILE_DELETE);
                }
            }
            //定义路径，分隔符，编码
            CsvWriter csvWriter = new CsvWriter(csvFilePath, ',', Charset.forName("UTF-8"));

            //写表头
            csvWriter.writeRecord(csvHeaders);


            for (int i = 0; i <dataSet.length ; i++) {
                String[] csvContent = new String[dataSet[i].length];
                for (short k = 0; k < dataSet[i].length; k++) {
                    csvContent[k] = dataSet[i][k]+"";
                }
                //迭代插入记录
                csvWriter.writeRecord(csvContent);
            }


            csvWriter.close();
            //System.out.println("<--------CSV文件写入成功-------->");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("请先关闭已经打开的文件！");
        }
    }

}


