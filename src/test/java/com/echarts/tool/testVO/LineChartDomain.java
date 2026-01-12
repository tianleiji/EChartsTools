package com.echarts.tool.testVO;

import com.echarts.tool.contract.strong.LineChartDataSupplier;
import lombok.Data;

@Data
public class LineChartDomain implements LineChartDataSupplier {
    private Integer id;
    private String name;
    private Integer value;
    private String type;
    private String color;

    @Override
    public String getXAData() {
        return name;
    }

    @Override
    public Number getYData() {
        return value;
    }
}
