package com.xiong.Kakou.service;

import com.xiong.Kakou.dao.BeijingTaxiMapper;
import com.xiong.Kakou.entity.BeijingTaxiModel;
import com.xiong.Kakou.entity.NycTaxiModel;
import com.xiong.Kakou.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/10/3 15:09
 * @description：
 * @modified By：
 * @version: $
 */
public class BeijingTaxiService {

    public int batchInsert(List<BeijingTaxiModel> list) {
        SqlSessionFactory factory = SqlSessionFactoryUtils.sqlSessionFactory_MySQL;
        // true 不开启事务，自动提交
        SqlSession s = factory.openSession(true);
        try {
            BeijingTaxiMapper mapper = s.getMapper(BeijingTaxiMapper.class);

            return mapper.batchInsert(list);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            s.close();
        }
    }

    public int selectCountByTime(NycTaxiModel model){
        SqlSessionFactory factory = SqlSessionFactoryUtils.sqlSessionFactory_MySQL;
        // true 不开启事务，自动提交
        SqlSession s = factory.openSession(true);
        int ret = 0;
        try {
            BeijingTaxiMapper mapper = s.getMapper(BeijingTaxiMapper.class);

            ret = mapper.selectCountByTime(model);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            s.close();
        }

        return ret;
    }
}
