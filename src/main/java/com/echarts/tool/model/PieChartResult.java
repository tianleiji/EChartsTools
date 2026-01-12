package com.echarts.tool.model;

import lombok.Data;

@Data
public class PieChartResult {
    /**
     * 饼图name
     */
    private String name;
    /**
     * 饼图value
     */
    private Number value;
}
