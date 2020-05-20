package com.zhuqc.framework.controller;

import com.zhuqc.framework.common.ApiResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Zhu.Qianchang
 * @date 2020-05-15
 */
@RestController
public class IndexController {

    @GetMapping("/index")
    public ApiResult<String> index() {
        return ApiResult.success("Hello World");
    }
}