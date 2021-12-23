package com.realmus.facade.response;

import com.realmus.facade.param.Banner;
import com.realmus.facade.param.Company;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


import java.util.List;

/**
 * @author hkpeng
 * @date 2021/12/22 - 11:46
 */

@Setter
@Getter
@ToString
public class QueryHomeResponse {
    /**
     * 轮播图信息集合
     */
    @ApiModelProperty(example = "home 模块1，轮播信息 ")
    private List<Banner> bannerList;

    /**
     * 企业信息
     */
    @ApiModelProperty(example = "home 模块2,企业信息 ")
    private Company company;

}
