package com.echarts.tool.extractor.ValueDriven;

import com.echarts.tool.contract.ValueDriven.LineChartDataSupplier;
import com.echarts.tool.exception.NullXAxisValueException;
import com.echarts.tool.model.metaData.LineChartData;
import com.echarts.tool.model.LineChartResult;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StrongTypeLineChart{

    public <T extends LineChartDataSupplier> LineChartResult getLineChart(List<T> objectList){
        if (objectList == null || objectList.isEmpty()) {
            return new LineChartResult();
        }

        LineChartResult lineChartResult = new LineChartResult();

        List<String> xData = new ArrayList<>();
        List<Number> Data = new ArrayList<>();

        String name = null;
        for (T obj : objectList) {
            try {
                // --- X 轴 ---
                if (obj.getXAData() == null) {
                    throw new NullXAxisValueException(obj);
                }
                xData.add(obj.getXAData());

                // --- Y 轴 ---
                if (obj.getLines().get(0).getData() == null) {
                    Data.add(0);
                }else {
                    Data.add(obj.getLines().get(0).getData());
                }

                name = obj.getLines().get(0).getName();
            } catch (Exception e) {
                throw new RuntimeException("Failed to read field from object: " + obj, e);
            }
        }
        lineChartResult.setX_data(xData);
        LineChartData lineChartData = LineChartData.builder().name(name).data(Data).build();
        lineChartResult.setSeries(new ArrayList<>(Arrays.asList(lineChartData)));
        return lineChartResult;
    }
}
