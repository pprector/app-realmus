package com.realmus.facade.response;

import com.realmus.domain.entity.DataDisplayEntity;
import com.realmus.facade.param.Banner;
import com.realmus.facade.param.Company;
import com.realmus.facade.param.DataDisplay;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * @author hkpeng
 * 关于我们   数据返回
 * @date 2021/12/27 - 14:53
 */
@Setter
@Getter
@ToString
public class
AboutUsResponse {

    @ApiModelProperty(example = "关于我们 banner")
    private Banner banner;

    @ApiModelProperty(example = "关于我们 banner 视频+图片")
    private Company company;

    @ApiModelProperty(example = "发展历程 轮播图")
    private List<Banner> courseBannerList;

    @ApiModelProperty(example = "数据展示 对象")
    private DataDisplay dataDisplay;

    @ApiModelProperty(example = "证书中心 N个图")
    private List<String> imgUrlList;
}
