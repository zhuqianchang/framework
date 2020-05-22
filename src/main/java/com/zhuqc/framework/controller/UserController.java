package com.zhuqc.framework.controller;

import com.zhuqc.framework.common.ApiResult;
import com.zhuqc.framework.entity.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.regex.Pattern;

/**
 * @author Zhu.Qianchang
 * @date 2020-05-21
 */
@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

//    @PostMapping("/add")
//    public ApiResult addUser(@RequestBody User user) {
//        if (user == null) {
//            return ApiResult.fail("对象不能为空");
//        }
//        if (StringUtils.isEmpty(user.getAccount()) || StringUtils.isEmpty(user.getPassword()) || StringUtils.isEmpty(user.getEmail())) {
//            return ApiResult.fail("账号、密码或邮箱不能为空");
//        }
//        if (user.getAccount().length() < 6 || user.getAccount().length() > 11) {
//            return ApiResult.fail("账号长度必须是6-11个字符");
//        }
//        if (user.getPassword().length() < 6 || user.getPassword().length() > 16) {
//            return ApiResult.fail("密码长度必须是6-16个字符");1
//        }
//        if (!Pattern.matches("^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$", user.getEmail())) {
//            return ApiResult.fail("邮箱格式不正确");
//        }
//        // 新增用户操作
//        return ApiResult.success();
//    }

//    @PostMapping("/add")
//    public ApiResult addUser(@RequestBody @Valid User user, BindingResult bindingResult) {
//        // 参数校验失败，会将错误信息封装成在BindingResult
//        for (ObjectError error : bindingResult.getAllErrors()) {
//            return ApiResult.fail(error.getDefaultMessage());
//        }
//        // 新增用户操作
//        return ApiResult.success();
//    }

    @PostMapping("/add")
    public ApiResult addUser(@RequestBody @Valid User user) {
        // 新增用户操作
        return ApiResult.success();
    }
}
