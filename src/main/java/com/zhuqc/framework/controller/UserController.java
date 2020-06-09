package com.zhuqc.framework.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhuqc.framework.common.ApiResult;
import com.zhuqc.framework.common.QueryResult;
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
        return ApiResult.success(userService.getById(id));
    }

    @PostMapping
    public ApiResult addUser(@RequestBody @Valid User user) {
        setCreateInfo(user);
        return ApiResult.success(userService.save(user));
    }

    @DeleteMapping("/{id}")
    public ApiResult deleteUser(@PathVariable("id") Long id) {
        return ApiResult.success(userService.removeById(id));
    }

    @PutMapping
    public ApiResult updateUser(@RequestBody @Valid User user) {
        setModifyInfo(user);
        return ApiResult.success(userService.updateById(user));
    }

    @GetMapping("/page")
    public ApiResult selectUserPage(@RequestParam String nickname,
                                    @RequestParam long pageNum,
                                    @RequestParam long pageSize) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.like("nickname", nickname);

        Page<User> page = new Page<>(pageNum, pageSize);

        IPage<User> userPage = userService.page(page, wrapper);
        return ApiResult.success(new QueryResult<>(userPage));
    }

    @GetMapping("/page2")
    public ApiResult selectUserPage2(@RequestParam String nickname,
                                     @RequestParam long pageNum,
                                     @RequestParam long pageSize) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.like("nickname", nickname);

        Page<User> page = new Page<>(pageNum, pageSize);

        IPage<User> userPage = userService.selectUserPage(page, wrapper);
        return ApiResult.success(new QueryResult<>(userPage));
    }
}
