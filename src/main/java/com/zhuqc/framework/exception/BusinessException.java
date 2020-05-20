package com.zhuqc.framework.exception;

/**
 * 业务异常
 *
 * @author Zhu.Qianchang
 * @date 2020-05-20
 */
public class BusinessException extends RuntimeException {

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }
}
