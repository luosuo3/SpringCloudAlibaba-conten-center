package com.cloud.contentcenter.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 王峥
 * @date 2020/7/5 2:01 下午
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserAddBonusDTO {
    /**
     * 用户ID
     */
    private Integer userId;
    /**
     * 积分
     */
    private Integer bonus;
}
