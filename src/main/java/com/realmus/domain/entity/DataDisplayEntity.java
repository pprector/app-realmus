package com.realmus.domain.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * @author hkpeng
 * 数据展示模块
 * @date 2021/12/28 - 17:46
 */
@Setter
@Getter
@ToString
public class DataDisplayEntity {
    /**
     * 背景图
     */
    MultimediaEntity background;
    /**
     * 数据详情集合
     */
    List<DataDetailsEntity> dataDetailsList;
}
