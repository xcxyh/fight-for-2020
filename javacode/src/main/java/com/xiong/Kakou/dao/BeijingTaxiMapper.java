package com.xiong.Kakou.dao;

import com.xiong.Kakou.entity.BeijingTaxiModel;
import com.xiong.Kakou.entity.NycTaxiModel;

import java.util.List;

public interface BeijingTaxiMapper {

    int batchInsert(List<BeijingTaxiModel> list);

    int selectCountByTime(NycTaxiModel model);
}
