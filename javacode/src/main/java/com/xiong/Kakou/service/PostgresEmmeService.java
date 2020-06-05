package com.xiong.Kakou.service;

import com.xiong.Kakou.dao.PostgresEmmeMapper;
import com.xiong.Kakou.entity.EmmeNodeModel;
import com.xiong.Kakou.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/6/4 17:56
 * @description：
 * @modified By：
 * @version: $
 */

public class PostgresEmmeService {


    public static void main(String[] args) {

        PostgresEmmeService postgresEmmeService = new PostgresEmmeService();
        Integer nodeid = 11781;
        EmmeNodeModel emmeNode = postgresEmmeService.selectNodeByID(nodeid);
        String geom = emmeNode.getGeom();
        geom = geom.substring(6, geom.length() - 1);

        String[] latlon = geom.split(" ");
        double lat = Double.parseDouble(latlon[1]); // 纬度在后面
        double lon = Double.parseDouble(latlon[0]);
        System.out.println(lat);
        System.out.println(lon);
    }

    public EmmeNodeModel selectNodeByID(Integer id) {

        //mybatis操作
        SqlSessionFactory factory = SqlSessionFactoryUtils.sqlSessionFactory_PostGis;

        //true 不开启事务，自动提交
        SqlSession s = factory.openSession(true);

        EmmeNodeModel result = null;

        try {

            PostgresEmmeMapper mapper = s.getMapper(PostgresEmmeMapper.class);

            List<EmmeNodeModel> list = mapper.selectNodeByID(id);
            if (list != null && list.size() > 0){
                result = list.get(0);
            }

        } catch (Exception e){
            e.printStackTrace();
        } finally {
            s.close();
        }
        return result;

    }


}
