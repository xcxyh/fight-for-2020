package com.xiong.Kakou.dao;

import com.xiong.Kakou.entity.EmmeNodeModel;

import java.util.List;

public interface PostgresEmmeMapper {

   List<EmmeNodeModel> selectNodeByID(Integer id);

}
