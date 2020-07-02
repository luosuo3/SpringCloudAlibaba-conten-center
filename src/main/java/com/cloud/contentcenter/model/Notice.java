package com.cloud.contentcenter.model;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * notice
 *
 * @author
 */
@Data
public class Notice implements Serializable {
    /**
     * id
     */
    private Integer id;

    /**
     * 内容
     */
    private String content;

    /**
     * 是否显示 0:否 1:是
     */
    private Boolean showFlag;

    /**
     * 创建时间
     */
    private Date createTime;

    private static final long serialVersionUID = 1L;
}