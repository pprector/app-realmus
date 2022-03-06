package com.realmus.product;

import com.realmus.common.enums.LanguageEnum;
import com.realmus.common.enums.MultimediaEnum;
import com.realmus.domain.entity.MultimediaEntity;
import com.realmus.domain.entity.ProductEntity;
import com.realmus.domain.entity.ProductInfoEntity;
import com.realmus.domain.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;

/**
 * @author hkpeng
 * 产品信息更新
 * @date 2022/3/6 - 15:45
 */
@SpringBootTest
public class ProductInfoUpdate {

    @Autowired
    private ProductService productService;

    /**
     * 中文更新
     */
    @Test
    public void ProductInfoUpdateCn() {
        String[] productIdList = {"202112311000001", "202112311000018", "202112311000040", "202112311000053", "202112311000085", "202112311000092"};
        //循环设置一张图
        for (String id : productIdList) {
            ProductInfoEntity productInfo = productService.getProductInfoById(LanguageEnum.CHINESE, id);

            MultimediaEntity entity = new MultimediaEntity();
            entity.setMultimediaType(MultimediaEnum.IMG);
            entity.setDescription("产品一级分类-化妆品-主图");
            entity.setMultimediaUrl("/home/prodect/prodect.jpg");

            productInfo.setMultimedia(entity);
            productService.productInfoUpdate(LanguageEnum.CHINESE, productInfo);
        }


    }

    /**
     * 英文
     */
    @Test
    public void ProductInfoUpdateEn() {

       /* productService.getProductInfoById();
        productService.productInfoUpdate();*/
    }


}
