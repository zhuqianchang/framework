package com.zhuqc.framework.controller;

import com.zhuqc.framework.common.ApiResult;
import com.zhuqc.framework.entity.User;
import com.zhuqc.framework.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author Zhu.Qianchang
 * @date 2020-05-21
 */
@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ApiResult getUser(@PathVariable("id") Long id) {
        return ApiResult.success(userService.getUser(id));
    }

    @PostMapping
    public ApiResult addUser(@RequestBody @Valid User user) {
        setCreateInfo(user);
        return ApiResult.success(userService.addUser(user));
    }

    @DeleteMapping("/{id}")
    public ApiResult deleteUser(@PathVariable("id") Long id) {
        return ApiResult.success(userService.deleteUser(id));
    }

    @PutMapping
    public ApiResult updateUser(@RequestBody @Valid User user) {
        setModifyInfo(user);
        return ApiResult.success(userService.updateUser(user));
    }
}
