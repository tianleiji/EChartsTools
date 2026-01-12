package com.echarts.tool.exception;

/**
 * X轴值为NULL异常
 */
public class NullXAxisValueException extends ChartDataExtractionException {
    public NullXAxisValueException(Object obj) {
        super("X-axis value is null for object: " + obj);
    }
}
