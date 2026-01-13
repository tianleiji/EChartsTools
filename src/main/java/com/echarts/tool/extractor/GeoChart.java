package com.echarts.tool.extractor;

import com.echarts.tool.contract.flexible.GeoChartDataSupplier;
import com.echarts.tool.exception.ChartFieldNotFoundException;
import com.echarts.tool.exception.NullNameValueException;
import com.echarts.tool.model.GeoChartResult;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static com.echarts.tool.check.Convert.parseDoubleNumber;

public class GeoChart {
    public <T extends GeoChartDataSupplier> List<GeoChartResult> getGeoChart(List<T> objectList){
        if(objectList == null || objectList.isEmpty()){
            return new ArrayList<GeoChartResult>();
        }

        T sample = objectList.get(0);
        String name = sample.getName();
        String longitude = sample.getLongitude();
        String latitude = sample.getLatitude();
        Class<?> CheckClazz = sample.getClass();
        try {
            CheckClazz.getDeclaredField(name); // 检查name字段是否存在
        } catch (NoSuchFieldException e) {
            throw new ChartFieldNotFoundException(name, CheckClazz);
        }
        try{
            CheckClazz.getDeclaredField(longitude); // 检查经度字段是否存在
        } catch (NoSuchFieldException e) {
            throw new ChartFieldNotFoundException(longitude, CheckClazz);
        }
        try {
            CheckClazz.getDeclaredField(latitude); // 检查纬度字段是否存在
        } catch (NoSuchFieldException e) {
            throw new ChartFieldNotFoundException(latitude, CheckClazz);
        }

        List<GeoChartResult> resultList = new ArrayList<>();
        for(T obj : objectList){
            GeoChartResult result = new GeoChartResult();
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

                ArrayList values = new ArrayList();

                // --- 经度 ---
                Field longitudeField = clazz.getDeclaredField(longitude);
                longitudeField.setAccessible(true);
                Object longitudeObj = longitudeField.get(obj);
                values.add(parseDoubleNumber(longitudeObj));

                // --- 纬度 ---
                Field latitudeFiled = clazz.getDeclaredField(latitude);
                latitudeFiled.setAccessible(true);
                Object latitudeObj = latitudeFiled.get(obj);
                values.add(parseDoubleNumber(latitudeObj));

                result.setValue(values);
            } catch (Exception e) {
                throw new RuntimeException("Failed to read field from object: " + obj, e);
            }

            resultList.add(result);
        }
        return resultList;
    }
}
