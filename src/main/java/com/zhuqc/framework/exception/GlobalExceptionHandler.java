package com.zhuqc.framework.exception;

import com.zhuqc.framework.common.ApiResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
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
     * MethodArgumentNotValidException 异常处理
     */
    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ApiResult methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        BindingResult bindingResult = e.getBindingResult();
        for (ObjectError error : bindingResult.getAllErrors()) {
            // 返回检验信息
            return ApiResult.fail(error.getDefaultMessage());
        }
        return ApiResult.fail("服务异常，请稍后重试");
    }

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
