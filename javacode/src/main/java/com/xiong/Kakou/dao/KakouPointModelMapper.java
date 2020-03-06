package com.xiong.Kakou.dao;

import com.xiong.Kakou.entity.KakouPointModel;

import java.util.List;

public interface KakouPointModelMapper {

    List<KakouPointModel> selectByIDLink(String ID_Link);

    List<KakouPointModel> selectAllStation();
}