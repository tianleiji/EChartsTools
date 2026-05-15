package com.echarts.tool.extractor.FieldDriven;

import com.echarts.tool.check.CheckField;
import com.echarts.tool.contract.FieldDriven.LineChartDataSupplier;
import com.echarts.tool.contract.FieldDriven.smallest.LineDataSupplier;
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


        String name = null;
        List<String> xData = new ArrayList<>();
        List<LineChartData> lineChartDataList = new ArrayList<>();
        for (T obj : objectList) {
            List<Number> Data = new ArrayList<>();
            try {
                String xFieldName = obj.getXAxis();
                name = obj.getLines().get(0).getName();
                List<LineDataSupplier> LineInfoList = obj.getLines();
                Class<?> clazz = obj.getClass();
                CheckField.CheckClassField(clazz, xFieldName);
                // --- X 轴 ---
                Field Xfield = clazz.getDeclaredField(xFieldName);
                Xfield.setAccessible(true);
                Object xValue = Xfield.get(obj);
                if (xValue == null) {
                    throw new NullXAxisValueException(obj);
                }
                xData.add(xValue.toString());
                for (LineDataSupplier f : LineInfoList) {
                    CheckField.CheckClassField(clazz, f.getDataName());

                    // --- Y 轴 ---
                    Field Yfield = clazz.getDeclaredField(f.getDataName());
                    Yfield.setAccessible(true);
                    Object yValue = Yfield.get(obj);
                    Data.add(parseIntegerNumber(yValue));
                }

            } catch (Exception e) {
                throw new RuntimeException("Failed to read field from object: " + obj, e);
            }
            LineChartData lineChartData = LineChartData.builder().name(name).data(Data).build();
            lineChartDataList.add(lineChartData);
        }
        lineChartResult.setX_data(xData);
        lineChartResult.setSeries(lineChartDataList);
        return lineChartResult;
    }
}
