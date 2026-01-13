package com.echarts.tool.contract.ValueDriven;

public interface GeoChartDataSupplier {
    /**
     * name的值
     * @return
     */
    String getName();
    /**
     * 经度值
     * @return
     */
    Double getLongitude();
    /**
     * 纬度值
     * @return
     */
    Double getLatitude();
}
