package com.echarts.tool.model;


import lombok.Data;

import java.util.List;

@Data
public class LineChartResult {
    /**
     * 横坐标
     */
    private List<String> X_data;

    /**
     * 纵坐标
     */
    private List<Number> Y_data;
}
