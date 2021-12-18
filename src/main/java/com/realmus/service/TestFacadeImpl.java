package com.realmus.service;


import com.realmus.common.error.BizException;
import com.realmus.common.result.ResultModel;
import com.realmus.common.util.ResultUtil;
import com.realmus.common.util.ValidationUtil;
import com.realmus.domain.entity.UserEntity;
import com.realmus.domain.service.TestService;
import com.realmus.facade.UserTest;
import com.realmus.facade.request.User;
import com.realmus.service.converter.TestConverter;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;


@RestController("/test")
public class TestFacadeImpl implements UserTest {
    private static final Logger logger = LoggerFactory.getLogger(TestFacadeImpl.class);
    private static final TestConverter mapper = Mappers.getMapper(TestConverter.class);

    @Autowired
    private TestService testService;


    @Override
    public ResultModel<User> pageUser() {
        return null;
    }


    @Override
    public ResultModel<Object> addUser(User user) {
        logger.debug("TestFacadeImpl addUser request : {0}", user);
        //ValidationUtil.validate(user);
        try {
            UserEntity userEntity = mapper.TestTOUserEntity(user);
            long addUser = testService.addUser(userEntity);
            return ResultUtil.success(addUser);
        } catch (BizException e) {
            logger.error("BizException  TestFacadeImpl addUser request : {0}", user, e);
            return ResultUtil.fail(e.getMessage());
        } catch (Exception e) {
            logger.error("Exception  TestFacadeImpl addUser request : {0}", user, e);
            return ResultUtil.fail(e.getMessage());
        }
    }
}
