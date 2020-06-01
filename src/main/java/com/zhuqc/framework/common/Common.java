package com.zhuqc.framework.common;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * 实体类基类
 *
 * @author Zhu.Qianchang
 * @date 2020-05-20
 */
@Getter
@Setter
public abstract class Common implements Serializable {

    private static final long serialVersionUID = 1164988873448427425L;

    /**
     * 创建人
     */
    private String createUser;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改人
     */
    private String modifyUser;

    /**
     * 修改时间
     */
    private Date modifyTime;
}
