package com.zhuqc.framework.dao;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.zhuqc.framework.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author Zhu.Qianchang
 * @date 2020-05-27
 */
@Mapper
public interface UserDao extends BaseMapper<User> {

    IPage<User> selectUserPage(IPage<User> page, @Param(Constants.WRAPPER) Wrapper<User> queryWrapper);
}
