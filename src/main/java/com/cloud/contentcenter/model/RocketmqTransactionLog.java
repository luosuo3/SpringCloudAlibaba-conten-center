package com.cloud.contentcenter.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * rocketmq_transaction_log
 *
 * @author
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RocketmqTransactionLog implements Serializable {
    /**
     * id
     */
    private Integer id;

    /**
     * 事务id
     */
    private String transactionId;

    /**
     * 日志
     */
    private String log;

    private static final long serialVersionUID = 1L;
}