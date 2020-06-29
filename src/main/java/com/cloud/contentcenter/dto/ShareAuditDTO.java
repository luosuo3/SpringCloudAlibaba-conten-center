package com.cloud.contentcenter.dto;

import com.cloud.contentcenter.enums.AuditStatusEnum;
import lombok.Data;

/**
 * @author 王峥
 * @date 2020/6/29 9:47 上午
 */
@Data
public class ShareAuditDTO {
    /**
     * 审核状态
     */
    private AuditStatusEnum auditStatusEnum;
    /**
     * 原因
     */
    private String reason;
}
