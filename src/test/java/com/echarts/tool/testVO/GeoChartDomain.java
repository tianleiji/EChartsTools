package com.echarts.tool.testVO;

import com.echarts.tool.contract.strong.GeoChartDataSupplier;
import lombok.Data;

@Data
public class GeoChartDomain implements GeoChartDataSupplier {
    private Long id;
    private String name;
    private Double type;
    private Double unit;

    @Override
    public String getName(){
        return name;
    }

    @Override
    public Double getLongitude() {
        return type;
    }

    @Override
    public Double getLatitude() {
        return unit;
    }
}
