package com.zhuqc.framework.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Zhu.Qianchang
 * @date 2020-05-18
 */
@Api(description = "Hello服务")
@RestController
public class HelloController {

    @ApiOperation(value = "打招呼", notes = "打招呼详情描述")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "用户名", required = true)
    })
    @GetMapping("/hello/{name}")
    public String hello(@PathVariable String name) {
        return String.format("Hello %s!", name);
    }
}
