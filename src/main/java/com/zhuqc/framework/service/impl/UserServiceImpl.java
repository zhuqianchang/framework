package com.zhuqc.framework.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhuqc.framework.dao.UserDao;
import com.zhuqc.framework.entity.User;
import com.zhuqc.framework.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Zhu.Qianchang
 * @date 2020-05-27
 */
@Service
@Transactional
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public IPage<User> selectUserPage(IPage<User> page, Wrapper<User> queryWrapper) {
        return userDao.selectUserPage(page, queryWrapper);
    }
}
