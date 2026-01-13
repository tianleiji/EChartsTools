package com.echarts.tool.extractor.strongType;

import com.echarts.tool.contract.strong.GeoChartDataSupplier;
import com.echarts.tool.exception.NullXAxisValueException;
import com.echarts.tool.model.GeoChartResult;

import java.util.ArrayList;
import java.util.List;

public class StrongTypeGeoChart {
    public <T extends GeoChartDataSupplier> List<GeoChartResult> getGeoChart(List<T> objectList){
        if(objectList == null || objectList.isEmpty()){
            return new ArrayList<GeoChartResult>();
        }

        List<GeoChartResult> resultList = new ArrayList<>();
        for (T obj : objectList) {
            GeoChartResult result = new GeoChartResult();
            try {
                // --- name ---
                if (obj.getName() == null) {
                    throw new NullXAxisValueException(obj);
                }
                result.setName(obj.getName());

                ArrayList values = new ArrayList();

                // --- 经度 ---
                if (obj.getLongitude() == null) {
                    values.add(0);
                }else {
                    values.add(obj.getLongitude());
                }

                // --- 纬度 ---
                if (obj.getLongitude() == null) {
                    values.add(0);
                }else {
                    values.add(obj.getLongitude());
                }

                result.setValue(values);
            } catch (Exception e) {
                throw new RuntimeException("Failed to read field from object: " + obj, e);
            }

            resultList.add(result);
        }

        return resultList;
    }
}
