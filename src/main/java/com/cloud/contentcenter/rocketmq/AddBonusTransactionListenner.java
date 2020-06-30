package com.cloud.contentcenter.rocketmq;

import com.cloud.contentcenter.dto.ShareAuditDTO;
import com.cloud.contentcenter.mapper.RocketmqTransactionLogMapper;
import com.cloud.contentcenter.model.RocketmqTransactionLog;
import com.cloud.contentcenter.model.RocketmqTransactionLogExample;
import com.cloud.contentcenter.service.content.ShareService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionState;
import org.apache.rocketmq.spring.support.RocketMQHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 王峥
 * @date 2020/6/30 10:17 上午
 */
@RocketMQTransactionListener( txProducerGroup = "tx-add-bonus-group")
@Slf4j
public class AddBonusTransactionListenner implements RocketMQLocalTransactionListener {
    @Resource
    private RocketmqTransactionLogMapper rocketmqTransactionLogMapper;
    @Resource
    private ShareService shareService;
    @Override
    public RocketMQLocalTransactionState executeLocalTransaction(Message message, Object o) {
        MessageHeaders headers = message.getHeaders();
        Integer  shareId = Integer.valueOf((String) headers.get("share_id"));
        String  transactionid = (String)headers.get(RocketMQHeaders.TRANSACTION_ID);
        log.info("id={}",shareId);
        try {
            shareService.auditByIdInDB((ShareAuditDTO)o,shareId);
            shareService.auditByIdWithRocketMqLog(shareId,(ShareAuditDTO) o,transactionid);
            return RocketMQLocalTransactionState.COMMIT;
        } catch (Exception e) {
            return RocketMQLocalTransactionState.ROLLBACK;
        }
    }

    @Override
    public RocketMQLocalTransactionState checkLocalTransaction(Message message) {
        MessageHeaders headers = message.getHeaders();
        String  transactionid = (String)headers.get(RocketMQHeaders.TRANSACTION_ID);
        RocketmqTransactionLogExample rocketmqTransactionLogExample = new RocketmqTransactionLogExample();
        rocketmqTransactionLogExample.createCriteria().andTransactionIdEqualTo(transactionid);
        List<RocketmqTransactionLog> rocketmqTransactionLogs = this.rocketmqTransactionLogMapper.selectByExample(rocketmqTransactionLogExample);
        if (rocketmqTransactionLogs.get(0) != null) {
            return RocketMQLocalTransactionState.COMMIT;
        } else {
            return RocketMQLocalTransactionState.ROLLBACK;
        }
    }
}
