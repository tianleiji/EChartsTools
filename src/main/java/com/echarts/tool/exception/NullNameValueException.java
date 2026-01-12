package com.echarts.tool.exception;

public class NullNameValueException extends ChartDataExtractionException{

    public NullNameValueException(Object obj){
        super("name value is null for object: " + obj);
    }

}
