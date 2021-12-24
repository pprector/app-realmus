package com.realmus.facade.request;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author hkpeng
 * @date 2021/12/24 - 15:19
 */
@Setter
@Getter
@ToString
public class ProductExcel {
    @ExcelProperty(value = "产品名称", index = 0)
    private String productName;

    @ExcelProperty(value = "一级分类", index = 1)
    private String productLv1Type;

    @ExcelProperty(value = "二级分类", index = 2)
    private String productLv2Type;

    @ExcelProperty(value = "功能简要", index = 3)
    private String description;

    @ExcelProperty(value = "主要原料", index = 4)
    private String ingredient;


}
