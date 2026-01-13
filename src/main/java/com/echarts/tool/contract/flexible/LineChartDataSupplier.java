package com.echarts.tool.contract.flexible;

import com.echarts.tool.contract.flexible.smallest.LineDataSupplier;

import java.util.List;

public interface LineChartDataSupplier {
    /**
     * 横坐标名称
     * @return
     */
    String getXAxis();

    /**
     * 线条信息定义
     * @return 包含所有线条数据的列表
     */
    List<LineDataSupplier> getLines();
}
