package com.echarts.tool.exception;

/**
 * 图表数据提取过程中发生的异常。
 * 所有与 ECharts 数据转换相关的错误都应抛出此异常或其子类。
 */
public class ChartDataExtractionException extends RuntimeException {

    public ChartDataExtractionException(String message) {
        super(message);
    }

    public ChartDataExtractionException(String message, Throwable cause) {
        super(message, cause);
    }
}
