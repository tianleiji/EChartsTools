package com.echarts.tool.testVO;

import com.echarts.tool.contract.FieldDriven.LineChartDataSupplier;
import com.echarts.tool.contract.FieldDriven.smallest.LineDataSupplier;
import com.echarts.tool.testVO.smallest.SmallestLineDomain;
import lombok.Data;

import java.util.Arrays;
import java.util.List;

@Data
public class LineChartDomain implements LineChartDataSupplier {
    private Integer id;
    private String name;
    private Integer value;
    private Integer type;
    private String color;


    @Override
    public String getXAxis() {
        return "name";
    }

    @Override
    public List<LineDataSupplier> getLines() {
        return Arrays.asList(
                new SmallestLineDomain("利润", "value")
        );
    }

}
