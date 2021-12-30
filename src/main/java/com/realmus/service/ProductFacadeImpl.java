package com.realmus.service;

import com.alibaba.excel.EasyExcel;
import com.realmus.common.enums.LanguageEnum;
import com.realmus.common.error.BizErrorEnum;
import com.realmus.common.error.BizException;
import com.realmus.common.result.ResultModel;
import com.realmus.common.util.ExcelListener;
import com.realmus.common.util.ResultUtil;
import com.realmus.common.util.ValidationUtil;
import com.realmus.domain.entity.ProductInfoEntity;
import com.realmus.domain.service.ProductService;
import com.realmus.facade.ProductFacade;
import com.realmus.facade.request.ProductExcel;
import com.realmus.service.converter.ProductFacadeConverter;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author hkpeng
 * @date 2021/12/24 - 15:15
 */
@RestController
@RequestMapping(value = "/product")
@Api(tags = "产品信息操作接口 ")
public class ProductFacadeImpl implements ProductFacade {
    private static final Logger logger = LoggerFactory.getLogger(NavigationFacadeImpl.class);

    @Autowired
    private ProductService productService;

    @Override
    @PostMapping("/{type}")
    public ResultModel<Object> productInfoImpl(@PathVariable Integer type, @RequestBody File file) {
        ValidationUtil.validate(file);
        logger.info("=====ProductFacadeImpl productInfoImpl request : " + file.getName());
        try {
            //解析数据
            ExcelListener excelListener = new ExcelListener();
            EasyExcel.read(file, ProductExcel.class, excelListener).sheet().doRead();
            List<Object> dataList = excelListener.getDataList();
            List<ProductInfoEntity> productInfoEntityList = ProductFacadeConverter.toProductEntity(dataList);
            productService.addProductList(LanguageEnum.getLanguageEnum(type), productInfoEntityList);
            return ResultUtil.success(null);
        } catch (BizException e) {
            logger.error("=====ProductFacadeImpl  productInfoImpl  BizException :}", e);
            return ResultUtil.fail(e.getMessage());
        } catch (Exception e) {
            logger.error("=====ProductFacadeImpl  productInfoImpl  Exception : ", e);
            return ResultUtil.fail(BizErrorEnum.E001.getMessage());
        }
    }
}
