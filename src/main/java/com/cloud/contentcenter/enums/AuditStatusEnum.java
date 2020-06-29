package com.cloud.contentcenter.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AuditStatusEnum {
    /**
     * 待审核
     */
    NOT_YES,
    /**
     * 审核通过
     */
    PASS,
    /**
     *
     */
    REJECT
}
