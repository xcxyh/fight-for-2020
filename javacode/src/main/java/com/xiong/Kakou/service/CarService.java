package com.xiong.Kakou.service;

import com.xiong.Kakou.dao.KakouCarModelMapper;
import com.xiong.Kakou.entity.KakouCarModel;
import com.xiong.Kakou.util.CSVUtil;
import com.xiong.Kakou.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/3/5 16:50
 * @description：
 * @modified By：
 * @version: $
 */
public class CarService {

    public ArrayList<String> selectHaopai() {
        //mybatis操作
        SqlSessionFactory factory = SqlSessionFactoryUtils.sqlSessionFactory_MySQL;
        //true 不开启事务，自动提交
        SqlSession s = factory.openSession(true);
        ArrayList<String> result = null;
        try {
            KakouCarModelMapper mapper = s.getMapper(KakouCarModelMapper.class);
            result = mapper.selectHaopai();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            s.close();
        }
        return result;
    }

    public ArrayList<KakouCarModel> selectByHphm(String hphm) {
        //mybatis操作
        SqlSessionFactory factory = SqlSessionFactoryUtils.sqlSessionFactory_MySQL;
        //true 不开启事务，自动提交
        SqlSession s = factory.openSession(true);
        ArrayList<KakouCarModel> result = null;
        try {
            KakouCarModelMapper mapper = s.getMapper(KakouCarModelMapper.class);
            result = mapper.selectByHphm(hphm);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            s.close();
        }
        return result;
    }


    public static void main(String[] args) throws Exception {
        //成功
        String filePath = "F:\\OD矩阵资料\\实验数据\\chuxinglian.csv";
        String[] csvHeaders = {"hphm", "gcsj", "sbbh", "CDBH","longitude","latitude"};

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
                    model.setHphm("Car0"+ carNum);
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

}
