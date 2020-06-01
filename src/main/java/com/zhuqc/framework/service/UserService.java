package com.zhuqc.framework.service;

import com.zhuqc.framework.entity.User;

/**
 * @author Zhu.Qianchang
 * @date 2020-05-27
 */
public interface UserService {

    User getUser(Long id);

    int addUser(User user);

    int deleteUser(Long id);

    int updateUser(User user);
}
