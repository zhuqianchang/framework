package com.zhuqc.framework.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zhuqc.framework.entity.User;

/**
 * @author Zhu.Qianchang
 * @date 2020-05-27
 */
public interface UserService extends IService<User> {

    IPage<User> selectUserPage(IPage<User> page, Wrapper<User> queryWrapper);
}
