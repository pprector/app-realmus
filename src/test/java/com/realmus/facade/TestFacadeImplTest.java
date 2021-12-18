package com.realmus.facade;

import com.realmus.common.result.ResultModel;
import com.realmus.facade.request.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author hkpeng
 * @date 2021/12/18 - 16:21
 */
@SpringBootTest
class TestFacadeImplTest {
    @Autowired
    private UserTest userTest;


    @Test
    void addUser() {
        User user = new User();
        user.setUserName("绝地求生");
        user.setAge(23);

        ResultModel<Object> objectResultModel = userTest.addUser(user);
        System.out.println(objectResultModel);
    }
}