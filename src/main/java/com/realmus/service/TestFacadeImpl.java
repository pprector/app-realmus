package com.realmus.service;


import com.realmus.common.result.ResultModel;
import com.realmus.facade.Test;
import com.realmus.facade.request.User;
import lombok.Data;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController("/test")
public class TestFacadeImpl implements Test {



    @Override
    public ResultModel<User> pageUser() {
        return null;
    }




    @Override
    public ResultModel<Object> addUser(User user) {

        return null;
    }
}
