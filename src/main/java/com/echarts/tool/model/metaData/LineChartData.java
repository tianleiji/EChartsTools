package com.echarts.tool.model.metaData;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class LineChartData {
    private String name;
    private List<Number> data;
}
