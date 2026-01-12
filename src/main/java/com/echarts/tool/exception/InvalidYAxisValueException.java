package com.echarts.tool.exception;

/**
 * Y轴无法转为数字异常
 */
public class InvalidYAxisValueException extends ChartDataExtractionException {
    public InvalidYAxisValueException(Class<?> clazz) {
        super("The value cannot be converted to a number, in class: " + clazz);
    }
}
