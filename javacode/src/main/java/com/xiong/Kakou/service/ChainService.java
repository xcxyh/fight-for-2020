package com.xiong.Kakou.service;

import com.xiong.Kakou.dao.ChainModelMapper;
import com.xiong.Kakou.dao.KakouCarModelMapper;
import com.xiong.Kakou.entity.ChainModel;
import com.xiong.Kakou.entity.VDToNodeModel;
import com.xiong.Kakou.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.ArrayList;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/3/15 10:34
 * @description：
 * @modified By：
 * @version: $
 */
public class ChainService {

    public ArrayList<ChainModel> selectChainByhp(String hphm){
        //mybatis操作
        SqlSessionFactory factory = SqlSessionFactoryUtils.sqlSessionFactory_MySQL;
        //true 不开启事务，自动提交
        SqlSession s = factory.openSession(true);
        ArrayList<ChainModel> result = null;
        try {
            ChainModelMapper mapper = s.getMapper(ChainModelMapper.class);
            result = mapper.selectChainByhp(hphm);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            s.close();
        }
        return result;
    }

    public int updateStatus(ChainModel model){
        //mybatis操作
        SqlSessionFactory factory = SqlSessionFactoryUtils.sqlSessionFactory_MySQL;
        //true 不开启事务，自动提交
        SqlSession s = factory.openSession(true);
        int result = 0;
        try {
            ChainModelMapper mapper = s.getMapper(ChainModelMapper.class);
            result = mapper.updateStatus(model);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            s.close();
        }
        return result;


    }

}
