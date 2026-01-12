package com.echarts.tool.exception;

/**
 * 字段不存在异常
 */
public class ChartFieldNotFoundException extends ChartDataExtractionException {
    public ChartFieldNotFoundException(String fieldName, Class<?> clazz) {
        super("Required chart field '" + fieldName + "' not found in class " + clazz.getSimpleName());
    }
}
