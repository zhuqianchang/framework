package com.zhuqc.framework.controller;

import com.zhuqc.framework.common.Common;

import java.util.Date;

/**
 * 控制器基类
 *
 * @author Zhu.Qianchang
 * @date 2020-05-20
 */
public abstract class BaseController {

    /**
     * 获得当前用户编号
     */
    public String getCurrentUserCode() {
        //TODO 待实现
        return null;
    }

    /**
     * 设置创建信息
     */
    public void setCreateInfo(Common common) {
        common.setCreateUser(getCurrentUserCode());
        common.setCreateDateTime(new Date());
        setModifyInfo(common);
    }

    /**
     * 设置修改信息
     */
    public void setModifyInfo(Common common) {
        common.setModifyUser(getCurrentUserCode());
        common.setModifyDateTime(new Date());
    }
}
