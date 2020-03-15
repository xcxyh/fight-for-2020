package com.xiong.Kakou.dao;

import com.xiong.Kakou.entity.ChainModel;

import java.util.ArrayList;

public interface ChainModelMapper {

    ArrayList<ChainModel> selectChainByhp(String hphm);

    int updateStatus(ChainModel model);

}