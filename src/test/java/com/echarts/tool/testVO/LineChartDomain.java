package com.echarts.tool.testVO;

import com.echarts.tool.contract.flexible.LineChartDataSupplier;
import lombok.Data;

@Data
public class LineChartDomain implements LineChartDataSupplier {
    private Integer id;
    private String name;
    private String value;
    private String type;
    private String color;

    @Override
    public String getXAxis() {
        return "name";
    }

    @Override
    public String getYAxis() {
        return "value";
    }
}
