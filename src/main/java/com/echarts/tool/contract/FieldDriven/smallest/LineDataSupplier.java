package com.echarts.tool.contract.FieldDriven.smallest;

public interface LineDataSupplier {
    /**
     * 线条名称
     * @return 线条名称
     */
    String getName();

    /**
     * 该线条的数据来源字段
     * @return 数据点集合
     */
    String getDataName();
}
