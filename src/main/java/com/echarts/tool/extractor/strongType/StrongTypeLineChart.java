package com.echarts.tool.extractor.strongType;

import com.echarts.tool.contract.strong.LineChartDataSupplier;
import com.echarts.tool.exception.NullXAxisValueException;
import com.echarts.tool.model.LineChartResult;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StrongTypeLineChart{

    public <T extends LineChartDataSupplier> LineChartResult getLineChart(List<T> objectList){
        LineChartResult lineChartResult = new LineChartResult();

        if (objectList == null || objectList.isEmpty()) {
            lineChartResult.setX_data(Collections.emptyList());
            lineChartResult.setY_data(Collections.emptyList());
            return lineChartResult;
        }

        List<String> xData = new ArrayList<>();
        List<Number> yData = new ArrayList<>();

        for (T obj : objectList) {
            try {
                // --- X 轴 ---
                if (obj.getXAData() == null) {
                    throw new NullXAxisValueException(obj);
                }
                xData.add(obj.getXAData());

                // --- Y 轴 ---
                if (obj.getYData() == null) {
                    yData.add(0);
                }else {
                    yData.add(obj.getYData());
                }
            } catch (Exception e) {
                throw new RuntimeException("Failed to read field from object: " + obj, e);
            }
        }
        lineChartResult.setX_data(xData);
        lineChartResult.setY_data(yData);
        return lineChartResult;
    }
}
