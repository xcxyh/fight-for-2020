package com.xiong.Kakou.dao;

import com.xiong.Kakou.entity.FuseLinkModel;

import java.util.List;

public interface FuseLinkMapper {

    List<FuseLinkModel> selectLinkByID(String ID_Link);

    int instertIntoNew(FuseLinkModel model);

    String selectValByModel(FuseLinkModel model);
}
