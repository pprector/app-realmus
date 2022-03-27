package com.realmus.product;

import com.realmus.common.enums.LanguageEnum;
import com.realmus.common.enums.MultimediaEnum;
import com.realmus.domain.entity.MultimediaEntity;
import com.realmus.domain.entity.ProductEntity;
import com.realmus.domain.entity.ProductInfoEntity;
import com.realmus.domain.service.ProductService;
import com.realmus.repository.mapper.CnProductMapper;
import com.realmus.repository.mapper.EnProductMapper;
import com.realmus.repository.model.ProductDO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author hkpeng
 * 产品信息更新
 * @date 2022/3/6 - 15:45
 */
@SpringBootTest
public class ProductInfoUpdate {

    @Autowired
    private ProductService productService;


    @Autowired
    private CnProductMapper cnProductMapper;

    @Autowired
    private EnProductMapper enProductMapper;

    /**
     * 中文更新
     */
    @Test
    public void ProductInfoUpdateCn() {
       // String[] productIdList = {"202112311000001", "202112311000018", "202112311000040", "202112311000053", "202112311000085", "202112311000092"};

        List<ProductDO> productInfoParentIdList = cnProductMapper.getProductInfoParentIdList();
        List<String> collect = productInfoParentIdList.stream().map(ProductDO::getProductId).collect(Collectors.toList());
        //循环设置一张图
        for (String id : collect) {
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

        String[] productIdList = {"202112311000001", "202112311000011", "202112311000034", "202112311000070", "202112311000087", "202112311000114", "202112311000128"};


        List<ProductDO> productInfoParentIdList = cnProductMapper.getProductInfoParentIdList();
        List<String> collect = productInfoParentIdList.stream().map(ProductDO::getProductId).collect(Collectors.toList());
        //循环设置一张图
        for (String id : collect) {
            ProductInfoEntity productInfo = productService.getProductInfoById(LanguageEnum.ENGLISH, id);

            MultimediaEntity entity = new MultimediaEntity();
            entity.setMultimediaType(MultimediaEnum.IMG);
            entity.setDescription("产品一级分类-化妆品-主图");
            entity.setMultimediaUrl("/home/prodect/prodect.jpg");

            productInfo.setMultimedia(entity);
            productService.productInfoUpdate(LanguageEnum.ENGLISH, productInfo);
        }
    }


}
