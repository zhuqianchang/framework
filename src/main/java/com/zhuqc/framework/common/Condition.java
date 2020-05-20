package com.zhuqc.framework.common;

import lombok.Getter;
import lombok.Setter;

/**
 * 分页查询条件基类
 *
 * @author Zhu.Qianchang
 * @date 2020-05-20
 */
@Getter
@Setter
public abstract class Condition {

    /**
     * 每页显示条数
     */
    private int numPerPage = 20;

    /**
     * 当前页号
     */
    private int pageNum = 1;

    /**
     * 排序字段
     */
    private String orderField;

    /**
     * 排序方式，默认降序
     */
    private String orderDirection = "desc";
}
