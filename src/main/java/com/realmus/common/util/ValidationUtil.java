package com.realmus.common.util;

import com.realmus.common.error.BizErrorEnum;
import com.realmus.common.error.BizException;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 入参校验工具类
 *
 * @author hkpeng
 * @date 2021/12/17 - 9:11
 */

public class ValidationUtil {

    private static final Logger logger = LoggerFactory.getLogger(ValidationUtil.class);
    private static final Validator VALIDATOR = Validation.buildDefaultValidatorFactory().getValidator();


    public static <T> void validate(T obj, Class<?>... groups) {
        Set<ConstraintViolation<T>> constraintViolations = VALIDATOR.validate(obj, groups);
        if (constraintViolations.size() > 0) {
            Map<String, String> map = constraintViolations.stream().collect(
                    Collectors.toMap(item -> item.getPropertyPath().toString(), ConstraintViolation::getMessage)
            );
            logger.error("参数校验不通过 message : {0}", map);
            throw new BizException(BizErrorEnum.A001.getMessage() + map);
        }
    }

}


