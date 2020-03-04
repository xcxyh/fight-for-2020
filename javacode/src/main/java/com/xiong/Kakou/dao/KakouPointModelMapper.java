package com.xiong.Kakou.dao;

import com.xiong.Kakou.entity.KakouPointModel;

public interface KakouPointModelMapper {
    int deleteByPrimaryKey(Integer FID);

    int insert(KakouPointModel record);

    int insertSelective(KakouPointModel record);

    KakouPointModel selectByPrimaryKey(Integer FID);

    int updateByPrimaryKeySelective(KakouPointModel record);

    int updateByPrimaryKey(KakouPointModel record);
}