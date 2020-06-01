package com.zhuqc.framework.dao;

import com.zhuqc.framework.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author Zhu.Qianchang
 * @date 2020-05-27
 */
@Mapper
public interface UserDao {

    User getUser(@Param("id") Long id);

    int addUser(User user);

    int deleteUser(@Param("id") Long id);

    int updateUser(User user);
}
