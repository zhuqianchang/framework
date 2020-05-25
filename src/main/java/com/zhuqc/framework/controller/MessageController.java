package com.zhuqc.framework.controller;

import com.zhuqc.framework.common.ApiResult;
import com.zhuqc.framework.common.ResultCode;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

/**
 * @author Zhu.Qianchang
 * @date 2020-05-25
 */
@RestController
@RequestMapping("/message")
public class MessageController {
    @Autowired
    private MessageSource messageSource;

    @ApiOperation("成功")
    @GetMapping("/success")
    public ApiResult<String> success() {
        Locale locale = LocaleContextHolder.getLocale();
        String message = messageSource.getMessage(ResultCode.SUCCESS.getMessage(), null, locale);
        return new ApiResult<>(ResultCode.SUCCESS.getCode(), null, message);
    }

    @ApiOperation("失败")
    @GetMapping("/fail")
    public ApiResult<String> failure() {
        Locale locale = LocaleContextHolder.getLocale();
        String message = messageSource.getMessage(ResultCode.FAIL.getMessage(), null, locale);
        return new ApiResult<>(ResultCode.SUCCESS.getCode(), null, message);
    }
}
