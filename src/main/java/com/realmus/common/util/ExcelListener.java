package com.realmus.common.util;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import org.apache.poi.ss.formula.functions.T;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hkpeng
 * Excel 监听工具类
 * @date 2021/12/24 - 15:29
 */

public class ExcelListener extends AnalysisEventListener<Object> {


    private List<Object> dataList = new ArrayList<>();

    @Override
    public void invoke(Object o, AnalysisContext analysisContext) {
        dataList.add(o);
    }

    /*
     * 数据解析完成执行
     * */
    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }

    public List<Object> getDataList() {
        return dataList;
    }

}
