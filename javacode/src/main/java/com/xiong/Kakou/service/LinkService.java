package com.xiong.Kakou.service;

import com.xiong.Kakou.dao.LinkModelMapper;
import com.xiong.Kakou.entity.LinkModel;
import com.xiong.Kakou.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;


/**
 * @author ：xiongcong
 * @date ：Created in 2020/3/6 12:05
 * @description：
 * @modified By：
 * @version: $
 */
public class LinkService {

    public List<LinkModel> selectAllLink(){
        //mybatis操作
        SqlSessionFactory factory = SqlSessionFactoryUtils.sqlSessionFactory_MySQL;
        //true 不开启事务，自动提交
        SqlSession s = factory.openSession(true);
        List<LinkModel> result = null;
        try {
            LinkModelMapper mapper = s.getMapper(LinkModelMapper.class);
            result = mapper.selectAllLink();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            s.close();
        }
        return result;
    }



}
