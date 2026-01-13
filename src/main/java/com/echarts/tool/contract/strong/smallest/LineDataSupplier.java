package com.echarts.tool.contract.strong.smallest;

public interface LineDataSupplier {
    /**
     * 线条名称
     * @return 线条名称
     */
    String getName();

    /**
     * 该线条的数据
     * @return 数据
     */
    Integer getData();
}
