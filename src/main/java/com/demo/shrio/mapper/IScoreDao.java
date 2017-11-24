package com.demo.shrio.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;

import com.demo.shiro.pojo.Score;


@Mapper
public interface IScoreDao{
	
    int updateScoreById(@Param("score") float score, @Param("id") int id);

    List<Score> getList();


}
