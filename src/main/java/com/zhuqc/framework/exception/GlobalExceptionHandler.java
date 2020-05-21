package com.zhuqc.framework.exception;

import com.zhuqc.framework.common.ApiResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Zhu.Qianchang
 * @date 2019/11/20.
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * BusinessException 异常处理
     */
    @ResponseBody
    @ExceptionHandler(BusinessException.class)
    public ApiResult businessExceptionHandler(BusinessException e) {
        log.error(e.getMessage(), e);
        // do something
        return ApiResult.fail(e.getMessage());
    }

    /**
     * Exception 异常处理
     */
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public ApiResult exceptionHandler(Exception e) {
        log.error(e.getMessage(), e);
        return ApiResult.fail("服务异常，请稍后重试");
    }
}
