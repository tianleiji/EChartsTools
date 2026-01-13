package com.echarts.tool.testVO.smallest;

import com.echarts.tool.contract.FieldDriven.smallest.LineDataSupplier;
import lombok.Data;

@Data
public class SmallestLineDomain implements LineDataSupplier {
    private String name;       // 线的名称，如 "利润"
    private String dataName;   // 对应的数据字段名，如 "value"

    public SmallestLineDomain(String name, String dataName) {
        this.name = name;
        this.dataName = dataName;
    }
    @Override
    public String getName(){
        return name;
    }

    @Override
    public String getDataName() {
        return dataName;
    }
}
