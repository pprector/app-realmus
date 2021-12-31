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
    void productInfoImpl() {
        File file = new File("C:\\Users\\issuser\\Desktop\\realmus_img\\产品信息.xls");
        ResultModel<Object> resultModel = productFacade.productInfoImpl(1, file);
        System.out.println(resultModel);
    }


    @Test
    void getProductInfo() {

        ResultModel<ProductResponse> productInfo = productFacade.getProductInfo(1, "软糖 GUMMY");
        System.out.println(JSON.toJSONString(productInfo, true));
    }
}