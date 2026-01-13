package com.echarts.tool.contract.ValueDriven;

import com.echarts.tool.contract.ValueDriven.smallest.LineDataSupplier;

import java.util.List;

public interface LineChartDataSupplier {
    /**
     * 横坐标值
     * @return
     */
    String getXAData();

    /**
     * 线条信息定义
     * @return
     */
    List<LineDataSupplier> getLines();
}
