package com.cloud.contentcenter.mapper;

import com.cloud.contentcenter.model.RocketmqTransactionLog;
import com.cloud.contentcenter.model.RocketmqTransactionLogExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface RocketmqTransactionLogMapper {
    long countByExample(RocketmqTransactionLogExample example);

    int deleteByExample(RocketmqTransactionLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RocketmqTransactionLog record);

    int insertSelective(RocketmqTransactionLog record);

    List<RocketmqTransactionLog> selectByExample(RocketmqTransactionLogExample example);

    RocketmqTransactionLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RocketmqTransactionLog record, @Param("example") RocketmqTransactionLogExample example);

    int updateByExample(@Param("record") RocketmqTransactionLog record, @Param("example") RocketmqTransactionLogExample example);

    int updateByPrimaryKeySelective(RocketmqTransactionLog record);

    int updateByPrimaryKey(RocketmqTransactionLog record);
}