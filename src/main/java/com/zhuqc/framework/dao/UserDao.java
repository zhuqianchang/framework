package com.zhuqc.framework.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhuqc.framework.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Zhu.Qianchang
 * @date 2020-05-27
 */
@Mapper
public interface UserDao extends BaseMapper<User> {
}
