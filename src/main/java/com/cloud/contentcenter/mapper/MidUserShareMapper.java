package com.cloud.contentcenter.mapper;

import com.cloud.contentcenter.model.MidUserShare;
import com.cloud.contentcenter.model.MidUserShareExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface MidUserShareMapper {
    long countByExample(MidUserShareExample example);

    int deleteByExample(MidUserShareExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MidUserShare record);

    int insertSelective(MidUserShare record);

    List<MidUserShare> selectByExample(MidUserShareExample example);

    MidUserShare selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MidUserShare record, @Param("example") MidUserShareExample example);

    int updateByExample(@Param("record") MidUserShare record, @Param("example") MidUserShareExample example);

    int updateByPrimaryKeySelective(MidUserShare record);

    int updateByPrimaryKey(MidUserShare record);
}