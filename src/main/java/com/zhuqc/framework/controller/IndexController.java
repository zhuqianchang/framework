package com.zhuqc.framework.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Zhu.Qianchang
 * @date 2020-05-15
 */
@RestController
public class IndexController {

    @GetMapping("/index")
    public String index() {
        return "Hello World";
    }
}