package com.echarts.tool.extractor.strongType;

import com.echarts.tool.contract.strong.PieChartDataSupplier;
import com.echarts.tool.exception.NullNameValueException;
import com.echarts.tool.model.PieChartResult;

import java.util.ArrayList;
import java.util.List;

public class StrongTypePieChart {
    public <T extends PieChartDataSupplier> List<PieChartResult> getPieChart(List<T> objectList){
        if(objectList == null || objectList.isEmpty()){
            return new ArrayList<PieChartResult>();
        }
        List<PieChartResult> resultList = new ArrayList<>();
        for(T obj : objectList){
            PieChartResult result = new PieChartResult();
            try {
                // --- name ---
                if (obj.getName() == null) {
                    throw new NullNameValueException(obj);
                }
                result.setName(obj.getName());

                // --- value ---
                if (obj.getValue() == null) {
                    result.setValue(0);
                }else {
                    result.setValue(obj.getValue());
                }
            } catch (Exception e) {
                throw new RuntimeException("Failed to read field from object: " + obj, e);
            }

            resultList.add(result);
        }
        return resultList;
    }
}
