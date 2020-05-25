package com.zhuqc.framework.controller;

import com.zhuqc.framework.common.ApiResult;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

/**
 * @author Zhu.Qianchang
 * @date 2020-05-25
 */
@RestController
@RequestMapping("/language")
public class LanguageController extends BaseController {

    @ApiOperation("切换语言")
    @PostMapping("/change")
    public ApiResult<String> changeLanguage(@RequestParam(name = "lang") @ApiParam(name = "lang", value = "语言", required = true) String lang) {
        // 在LocaleChangeInterceptor中已切换，此处无需处理
        return getLanguage();
    }

    @ApiOperation("获得当前语言")
    @GetMapping
    public ApiResult<String> getLanguage() {
        Locale locale = LocaleContextHolder.getLocale();
        return ApiResult.success(locale.toString());
    }
}
