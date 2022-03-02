package com.realmus.service;

import com.alibaba.excel.EasyExcel;
import com.realmus.common.enums.LanguageEnum;
import com.realmus.common.error.BizErrorEnum;
import com.realmus.common.error.BizException;
import com.realmus.common.result.ResultModel;
import com.realmus.common.util.ExcelListener;
import com.realmus.common.util.LanguageUtil;
import com.realmus.common.util.ResultUtil;
import com.realmus.common.util.ValidationUtil;
import com.realmus.domain.entity.ProductInfoEntity;
import com.realmus.domain.service.ProductService;
import com.realmus.facade.ProductFacade;
import com.realmus.facade.request.ProductExcel;
import com.realmus.facade.response.ProductResponse;
import com.realmus.service.converter.ProductFacadeConverter;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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
    public ResultModel<Object> productInfoImpl(@PathVariable String type, @RequestBody File file) {
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

    @Override
    @ApiOperation(value = "产品信息模块 根据产品1级分类名称获取数据", httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "lv1Name", value = "产品一级分类名称", required = true, dataType = "string")
    }
    )
    @GetMapping(value = "/{lv1Name}", params = {"language"})
    public ResultModel<ProductResponse> getProductInfo(@PathVariable String lv1Name, HttpServletRequest httpServletRequest) {
        logger.info("=====ProductFacadeImpl productInfoImpl request : " + lv1Name);
        try {
            LanguageEnum languageEnum = LanguageUtil.getLanguageEnum(httpServletRequest);
            ProductInfoEntity productInfoEntity = productService.getProductInfo(languageEnum, lv1Name);
            return ResultUtil.success(ProductFacadeConverter.ProductResponse(productInfoEntity));
        } catch (BizException e) {
            logger.error("=====ProductFacadeImpl  productInfoImpl  BizException :}", e);
            return ResultUtil.fail(e.getMessage());
        } catch (Exception e) {
            logger.error("=====ProductFacadeImpl  productInfoImpl  Exception : ", e);
            return ResultUtil.fail(BizErrorEnum.E001.getMessage());
        }
    }

    @ApiOperation(value = "产品信息模块 根据产品分类-产品名称搜索", httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "input", value = "搜索条件", required = false, dataType = "string")
    }
    )
    @GetMapping(value = "/{input}", params = {"language"})
    @Override
    public ResultModel<List<ProductResponse>> productSearch(@PathVariable String input, HttpServletRequest httpServletRequest) {
        logger.info("=====ProductFacadeImpl productInfoImpl request : " + input);
        try {
            LanguageEnum languageEnum = LanguageUtil.getLanguageEnum(httpServletRequest);
            List<ProductInfoEntity> productInfoEntityList = productService.productSearch(languageEnum, input);
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
