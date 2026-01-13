package com.echarts.tool.extractor;

import com.echarts.tool.contract.flexible.PieChartDataSupplier;
import com.echarts.tool.exception.ChartFieldNotFoundException;
import com.echarts.tool.exception.NullNameValueException;
import com.echarts.tool.model.PieChartResult;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static com.echarts.tool.check.Convert.parseFloatNumber;

public class PieChart {
    public <T extends PieChartDataSupplier> List<PieChartResult> getPieChart(List<T> objectList){

        if(objectList == null || objectList.isEmpty()){
            return new ArrayList<PieChartResult>();
        }

        List<PieChartResult> results = new ArrayList<>();

        T sample = objectList.get(0);
        String name = sample.getName();
        String value = sample.getValue();

        Class<?> CheckClazz = sample.getClass();
        try {
            CheckClazz.getDeclaredField(name); // 检查name字段是否存在
        } catch (NoSuchFieldException e) {
            throw new ChartFieldNotFoundException(name, CheckClazz);
        }
        try{
            CheckClazz.getDeclaredField(value); // 检查value字段是否存在
        } catch (NoSuchFieldException e) {
            throw new ChartFieldNotFoundException(value, CheckClazz);
        }

        for (T obj : objectList) {
            PieChartResult result = new PieChartResult();
            try {
                Class<?> clazz = obj.getClass();

                // --- name ---
                Field nameField = clazz.getDeclaredField(name);
                nameField.setAccessible(true);
                Object xValue = nameField.get(obj);
                if (xValue == null) {
                    throw new NullNameValueException(obj);
                }
                result.setName(xValue.toString());

                // --- value ---
                Field valueField = clazz.getDeclaredField(value);
                valueField.setAccessible(true);
                Object yValue = valueField.get(obj);
                result.setValue(parseFloatNumber(yValue));
            } catch (Exception e) {
                throw new RuntimeException("Failed to read field from object: " + obj, e);
            }

            results.add(result);
        }
        return results;
    }
}
