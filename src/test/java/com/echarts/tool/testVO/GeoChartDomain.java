package com.echarts.tool.testVO;

import com.echarts.tool.contract.flexible.GeoChartDataSupplier;
import lombok.Data;

@Data
public class GeoChartDomain implements GeoChartDataSupplier {
    private Long id;
    private String name;
    private String type;
    private String unit;

    @Override
    public String getName(){
        return "name";
    }
    @Override
    public String getLongitude() {
        return "type";
    }

    @Override
    public String getLatitude() {
        return "unit";
    }
}
