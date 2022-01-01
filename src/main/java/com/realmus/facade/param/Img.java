package com.realmus.facade.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * realmus.com
 *
 * @Author hkpeng
 * @Description TODO
 * @Date 2022/1/1 21:30
 * @Version 1.0
 */
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Img {
    @ApiModelProperty(example = "图片链接地址")
    private String url;
    @ApiModelProperty(example = "图片alt")
    private String desc;
}
