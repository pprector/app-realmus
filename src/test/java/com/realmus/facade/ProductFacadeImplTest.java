package com.realmus.facade;

import com.alibaba.fastjson.JSON;
import com.realmus.common.result.ResultModel;
import com.realmus.facade.response.ProductResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author hkpeng
 * @date 2021/12/24 - 16:51
 */
@SpringBootTest
class ProductFacadeImplTest {
    @Autowired
    private ProductFacade productFacade;

    @Test
    void productInfoImplCN() {
        File file = new File("C:\\Users\\peng\\Desktop\\锐麦文档\\产品信息中文.xls");
        ResultModel<Object> resultModel = productFacade.productInfoImpl("zh-CN", file);
        System.out.println(resultModel);
    }


    @Test
    void productInfoImplEN() {
        File file = new File("C:\\Users\\peng\\Desktop\\锐麦文档\\产品信息英文.xls");
        ResultModel<Object> resultModel = productFacade.productInfoImpl("en-US", file);
        System.out.println(resultModel);
    }


    @Test
    void getProductInfo() {

    }
}