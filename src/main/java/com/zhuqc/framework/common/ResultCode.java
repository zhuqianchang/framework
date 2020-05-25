package com.zhuqc.framework.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * API 统一返回状态码
 *
 * @author Zhu.Qianchang
 * @date 2020-05-20
 */
@Getter
@AllArgsConstructor
public enum ResultCode {

    SUCCESS(200, "success"),

    FAIL(500, "fail"),

    /* 参数错误：1000 - 1999 */

    /* 用户错误：2000 - 2999 */

    /* 接口异常：3000 - 3999 */
    ;

    private Integer code;

    private String message;
}
