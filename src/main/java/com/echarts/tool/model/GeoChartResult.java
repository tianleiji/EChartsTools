package com.echarts.tool.model;

import lombok.Data;

import java.util.ArrayList;

@Data
public class GeoChartResult {
    /**
     * 地点名称
     */
    private String name;
    /**
     * 经纬度键值对
     */
    private ArrayList value;
}
