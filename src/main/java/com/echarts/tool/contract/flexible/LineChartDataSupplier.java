package com.echarts.tool.contract.flexible;

public interface LineChartDataSupplier {
    /**
     * 横坐标名称
     * @return
     */
    String getXAxis();

    /**
     * 纵坐标名称
     * @return
     */
    String getYAxis();
}
