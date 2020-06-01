package com.zhuqc.framework.service.impl;

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
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User getUser(Long id) {
        return userDao.getUser(id);
    }

    @Override
    public int addUser(User user) {
        return userDao.addUser(user);
    }

    @Override
    public int deleteUser(Long id) {
        return userDao.deleteUser(id);
    }

    @Override
    public int updateUser(User user) {
        return userDao.updateUser(user);
    }
}
