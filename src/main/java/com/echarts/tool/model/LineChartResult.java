package com.echarts.tool.model;


import com.echarts.tool.model.metaData.LineChartData;
import lombok.Data;

import java.util.List;

@Data
public class LineChartResult{
    /**
     * 横坐标
     */
    private List<String> X_data;

    /**
     * series数据
     */
    private List<LineChartData> series;
}
