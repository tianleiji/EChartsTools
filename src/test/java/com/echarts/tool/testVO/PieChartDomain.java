package com.echarts.tool.testVO;

import com.echarts.tool.contract.strong.PieChartDataSupplier;
import lombok.Data;

@Data
public class PieChartDomain implements PieChartDataSupplier {
    private Integer id;
    private String name;
    private Double value;
    private Integer count;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Number getValue() {
        return value;
    }
}
