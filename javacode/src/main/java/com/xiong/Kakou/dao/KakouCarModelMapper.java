package com.xiong.Kakou.dao;

import com.xiong.Kakou.entity.KakouCarModel;

import java.util.ArrayList;

public interface KakouCarModelMapper {
    int insert(KakouCarModel record);

    int insertSelective(KakouCarModel record);

    ArrayList<KakouCarModel> selectByHphm(String hphm);


    ArrayList<String> selectHaopai();
}