package com.zhuqc.framework.controller;

import com.zhuqc.framework.common.ApiResult;
import com.zhuqc.framework.common.Common;
import com.zhuqc.framework.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * 控制器基类
 *
 * @author Zhu.Qianchang
 * @date 2020-05-20
 */
@Slf4j
public abstract class BaseController {

//    /**
//     * BusinessException 异常处理
//     */
//    @ResponseBody
//    @ExceptionHandler(BusinessException.class)
//    public ApiResult businessExceptionHandler(BusinessException e) {
//        log.error(e.getMessage(), e);
//        // do something
//        return ApiResult.fail(e.getMessage());
//    }
//
//    /**
//     * Exception 异常处理
//     */
//    @ResponseBody
//    @ExceptionHandler(Exception.class)
//    public ApiResult exceptionHandler(Exception e) {
//        log.error(e.getMessage(), e);
//        return ApiResult.fail("服务异常，请稍后重试");
//    }

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
