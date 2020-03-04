package com.xiong.Kakou.service;

import com.xiong.Kakou.dao.KakouPointModelMapper;
import com.xiong.Kakou.entity.KakouPointModel;
import com.xiong.Kakou.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/3/4 17:38
 * @description：
 * @modified By：
 * @version: $
 */
public class TestServcie {

    public KakouPointModel selectByPrimaryKey(Integer FID){
//mybatis操作
        SqlSessionFactory factory = SqlSessionFactoryUtils.sqlSessionFactory_MySQL;
        //true 不开启事务，自动提交
        SqlSession s = factory.openSession(true);
        KakouPointModel result = null;
        try {
            KakouPointModelMapper mapper = s.getMapper(KakouPointModelMapper.class);
            result = mapper.selectByPrimaryKey(FID);
        } catch (Exception e){
            e.printStackTrace();
        }finally {
            s.close();
        }
        return result;
    }


    public static void main(String[] args) {
        //成功
        TestServcie service = new TestServcie();
        KakouPointModel result =   service.selectByPrimaryKey(5);
        System.out.println(result);
    }
}
