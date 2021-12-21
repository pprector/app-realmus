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
import org.mapstruct.factory.Mappers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TestFacadeImpl implements UserTest {
    private static final Logger logger = LoggerFactory.getLogger(TestFacadeImpl.class);
    private static final TestConverter mapper = Mappers.getMapper(TestConverter.class);

    @Autowired
    private TestService testService;


    @Override
    @RequestMapping("/page/user")
    public ResultModel<User> pageUser() {
        logger.info("=====TestFacadeImpl pageUser request : " );
        try {
            User user = new User();
            user.setUserName("测试用户");
            user.setAge(13);
            return ResultUtil.success(user);
        } catch (BizException e) {
            logger.error("BizException  TestFacadeImpl addUser request : {0}",  e);
            return ResultUtil.fail(e.getMessage());
        } catch (Exception e) {
            logger.error("Exception  TestFacadeImpl addUser request : {0}",  e);
            return ResultUtil.fail(e.getMessage());
        }
    }

    @RequestMapping("/addUser")
    @Override
    public ResultModel<Object> addUser(@RequestBody User user) {
        logger.info("=====TestFacadeImpl addUser request : " + user);
        ValidationUtil.validate(user);
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
