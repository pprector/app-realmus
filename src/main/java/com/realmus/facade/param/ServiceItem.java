package com.realmus.facade.param;

import com.realmus.domain.entity.PublicInfoEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * @author hkpeng
 * 服务项目
 * @date 2021/12/27 - 17:09
 */
@ToString
@Getter
@Setter
public class ServiceItem {
    /**
     * 标题
     */
    private String headLine;
    /**
     * 描述
     */
    private String description;
    /**
     * 服务项目 Banner
     * 六个描述信息
     */
    private List<PublicInfo> ItemInfoList;
}
