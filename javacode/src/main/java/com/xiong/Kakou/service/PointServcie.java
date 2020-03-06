package com.xiong.Kakou.service;

import com.xiong.Kakou.dao.KakouPointModelMapper;
import com.xiong.Kakou.entity.KakouPointModel;
import com.xiong.Kakou.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/3/4 17:38
 * @description：
 * @modified By：
 * @version: $
 */
public class PointServcie {

    public List<KakouPointModel> selectByIDLink(String ID_Link) {
        //mybatis操作
        SqlSessionFactory factory = SqlSessionFactoryUtils.sqlSessionFactory_MySQL;
        //true 不开启事务，自动提交
        SqlSession s = factory.openSession(true);
        List<KakouPointModel> result = null;
        try {
            KakouPointModelMapper mapper = s.getMapper(KakouPointModelMapper.class);
            result = mapper.selectByIDLink(ID_Link);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            s.close();
        }
        return result;
    }

    public List<KakouPointModel> selectAllStation() {
        //mybatis操作
        SqlSessionFactory factory = SqlSessionFactoryUtils.sqlSessionFactory_MySQL;
        //true 不开启事务，自动提交
        SqlSession s = factory.openSession(true);
        List<KakouPointModel> result = null;
        try {
            KakouPointModelMapper mapper = s.getMapper(KakouPointModelMapper.class);
            result = mapper.selectAllStation();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            s.close();
        }
        return result;
    }

    public static void main(String[] args) {
        PointServcie pointServcie = new PointServcie();

        List<KakouPointModel> station = pointServcie.selectAllStation();

        List<KakouPointModel> point = pointServcie.selectByIDLink(station.get(2).getID_Link());

        System.out.println(point.get(0));

    }
}
