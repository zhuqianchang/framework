package com.zhuqc.framework.validator;

import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

/**
 * @author Zhu.Qianchang
 * @date 2020-05-22
 */
public class PhoneValidator implements ConstraintValidator<Phone, String> {

    @Override
    public boolean isValid(String phone, ConstraintValidatorContext context) {
        // 校验手机格式
        if (StringUtils.isNotBlank(phone)) {
            return Pattern.matches("^1[3-9]\\d{9}", phone);
        }
        return true;
    }
}
