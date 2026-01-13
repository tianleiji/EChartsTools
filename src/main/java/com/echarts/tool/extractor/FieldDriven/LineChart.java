package com.echarts.tool.extractor.FieldDriven;

import com.echarts.tool.contract.FieldDriven.LineChartDataSupplier;
import com.echarts.tool.exception.ChartFieldNotFoundException;
import com.echarts.tool.exception.NullXAxisValueException;
import com.echarts.tool.model.metaData.LineChartData;
import com.echarts.tool.model.LineChartResult;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.echarts.tool.check.Convert.parseIntegerNumber;

public class LineChart{

    public <T extends LineChartDataSupplier> LineChartResult getLineChart(List<T> objectList){
        if (objectList == null || objectList.isEmpty()) {
            return new LineChartResult();
        }

        LineChartResult lineChartResult = new LineChartResult();

        T sample = objectList.get(0);
        String xFieldName = sample.getXAxis();
        String name = sample.getLines().get(0).getName();
        String dataFieldName = sample.getLines().get(0).getDataName();

        Class<?> CheckClazz = sample.getClass();
        try {
            CheckClazz.getDeclaredField(xFieldName); // 检查 X 字段是否存在
        } catch (NoSuchFieldException e) {
            throw new ChartFieldNotFoundException(xFieldName, CheckClazz);
        }
        try{
            CheckClazz.getDeclaredField(dataFieldName); // 检查 Y 字段是否存在
        } catch (NoSuchFieldException e) {
            throw new ChartFieldNotFoundException(dataFieldName, CheckClazz);
        }

        List<String> xData = new ArrayList<>();
        List<Number> Data = new ArrayList<>();
        for (T obj : objectList) {
            try {
                Class<?> clazz = obj.getClass();

                // --- X 轴 ---
                Field Xfield = clazz.getDeclaredField(xFieldName);
                Xfield.setAccessible(true);
                Object xValue = Xfield.get(obj);
                if (xValue == null) {
                    throw new NullXAxisValueException(obj);
                }
                xData.add(xValue.toString());

                // --- Y 轴 ---
                Field Yfield = clazz.getDeclaredField(dataFieldName);
                Yfield.setAccessible(true);
                Object yValue = Yfield.get(obj);
                Data.add(parseIntegerNumber(yValue));
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
