package com.echarts.tool.contract.flexible;

public interface GeoChartDataSupplier {
    /**
     * 作为name的字段名称
     * @return
     */
    String getName();
    /**
     * 作为经度的字段名称
     * @return
     */
    String getLongitude();
    /**
     * 作为纬度的字段名称
     * @return
     */
    String getLatitude();
}
