package com.cloud.contentcenter.model;

import java.io.Serializable;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * mid_user_share
 * @author 
 */
@Data
public class MidUserShare implements Serializable {
    private Integer id;

    /**
     * share.id
     */
    private Integer shareId;

    /**
     * user.id
     */
    private Integer userId;

    private static final long serialVersionUID = 1L;
}