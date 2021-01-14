package com.xiong.Kakou.service;

import com.xiong.Kakou.dao.FuseLinkMapper;
import com.xiong.Kakou.dao.KakouCarModelMapper;
import com.xiong.Kakou.entity.FuseLinkModel;
import com.xiong.Kakou.entity.VDToNodeModel;
import com.xiong.Kakou.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/12/19 15:38
 * @description：
 * @modified By：
 * @version: $
 */
public class FuseLinkService {

    public List<FuseLinkModel> selectLinkByID(String ID_Link) {
        //mybatis操作
        SqlSessionFactory factory = SqlSessionFactoryUtils.sqlSessionFactory_MySQL;
        //true 不开启事务，自动提交
        SqlSession s = factory.openSession(true);
        List<FuseLinkModel> result = null;
        try {
            FuseLinkMapper mapper = s.getMapper(FuseLinkMapper.class);
            result = mapper.selectLinkByID(ID_Link);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            s.close();
        }
        return result;
    }

    public int instertIntoNew(FuseLinkModel model) {
        //mybatis操作
        SqlSessionFactory factory = SqlSessionFactoryUtils.sqlSessionFactory_MySQL;
        //true 不开启事务，自动提交
        SqlSession s = factory.openSession(true);
        int result = 0;
        try {
            FuseLinkMapper mapper = s.getMapper(FuseLinkMapper.class);
            result = mapper.instertIntoNew(model);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            s.close();
        }
        return result;
    }

    public String selectValByModel(FuseLinkModel model){
        //mybatis操作
        SqlSessionFactory factory = SqlSessionFactoryUtils.sqlSessionFactory_MySQL;
        //true 不开启事务，自动提交
        SqlSession s = factory.openSession(true);
        String result = "0";
        try {
            FuseLinkMapper mapper = s.getMapper(FuseLinkMapper.class);
            result = mapper.selectValByModel(model);
            if ("".equals(result)){
                result = "0";
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            s.close();
        }
        return result;
    }
}
