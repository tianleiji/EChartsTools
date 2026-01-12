package com.echarts.tool.extractor;

import com.echarts.tool.contract.flexible.LineChartDataSupplier;
import com.echarts.tool.exception.ChartFieldNotFoundException;
import com.echarts.tool.exception.InvalidYAxisValueException;
import com.echarts.tool.exception.NullXAxisValueException;
import com.echarts.tool.model.LineChartResult;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LineChart{

    public <T extends LineChartDataSupplier> LineChartResult getLineChart(List<T> objectList){
        LineChartResult lineChartResult = new LineChartResult();

        if (objectList == null || objectList.isEmpty()) {
            lineChartResult.setX_data(Collections.emptyList());
            lineChartResult.setY_data(Collections.emptyList());
            return lineChartResult;
        }

        T sample = objectList.get(0);
        String xFieldName = sample.getXAxis();
        String yFieldName = sample.getYAxis();

        Class<?> CheckClazz = sample.getClass();
        try {
            CheckClazz.getDeclaredField(xFieldName); // 检查 X 字段是否存在
        } catch (NoSuchFieldException e) {
            throw new ChartFieldNotFoundException(xFieldName, CheckClazz);
        }
        try{
            CheckClazz.getDeclaredField(yFieldName); // 检查 Y 字段是否存在
        } catch (NoSuchFieldException e) {
            throw new ChartFieldNotFoundException(yFieldName, CheckClazz);
        }

        List<String> xData = new ArrayList<>();
        List<Number> yData = new ArrayList<>();

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
                Field Yfield = clazz.getDeclaredField(yFieldName);
                Yfield.setAccessible(true);
                Object yValue = Yfield.get(obj);
                Number num;
                if (yValue == null) {
                    num = 0;
                } else if (yValue instanceof Number) {
                    num = (Number) yValue;
                } else {
                    throw new InvalidYAxisValueException(obj.getClass());
                }
                yData.add(num);
            } catch (Exception e) {
                throw new RuntimeException("Failed to read field from object: " + obj, e);
            }
        }
        lineChartResult.setX_data(xData);
        lineChartResult.setY_data(yData);
        return lineChartResult;
    }
}
