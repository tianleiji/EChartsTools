package com.echarts.tool.check;

import com.echarts.tool.exception.ChartFieldNotFoundException;

public class CheckField {

    public static void CheckClassField(Class<?> clazz, String fieldName) {
        try {
            clazz.getDeclaredField(fieldName);
        } catch (NoSuchFieldException e) {
            throw new ChartFieldNotFoundException(fieldName, clazz);
        }
    }
}
