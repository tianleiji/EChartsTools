package com.echarts.tool;

import com.echarts.tool.extractor.GeoChart;
import com.echarts.tool.extractor.LineChart;
import com.echarts.tool.extractor.PieChart;
import com.echarts.tool.extractor.strongType.StrongTypeLineChart;
import com.echarts.tool.extractor.strongType.StrongTypePieChart;
import com.echarts.tool.model.GeoChartResult;
import com.echarts.tool.model.PieChartResult;
import com.echarts.tool.testVO.GeoChartDomain;
import com.echarts.tool.testVO.LineChartDomain;
import com.echarts.tool.model.LineChartResult;
import com.echarts.tool.testVO.PieChartDomain;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest
    extends TestCase
{

    public static void main(String[] args) {
        GeoChartTest();
    }
    /**
     * Create the test case
     *
     */
    public static void LineChartTest()
    {
        // 1. 准备测试数据
        List<LineChartDomain> testList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            LineChartDomain domain = new LineChartDomain();
            domain.setId(i);
            domain.setName("test" + i);
            domain.setValue(String.valueOf(i));
            domain.setColor("red" + i);
            domain.setType("type" + i);
            testList.add(domain);
        }
        // 2. 创建你的服务类实例（假设叫 ChartService）
        LineChart service = new LineChart();

        // 3. 调用你的方法
        LineChartResult result = service.getLineChart(testList);

        // 4. 打印结果验证
        System.out.println("X轴数据: " + result.getX_data());
        System.out.println("Y轴数据: " + result.getY_data());
    }


    public static void PieChartTest()
    {
        // 1. 准备测试数据
        List<PieChartDomain> testList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            PieChartDomain domain = new PieChartDomain();
            domain.setId(i);
            domain.setName("test" + i);
            domain.setValue((double)(i+10));
            testList.add(domain);
        }
        // 2. 创建你的服务类实例（假设叫 ChartService）
        StrongTypePieChart service = new StrongTypePieChart();

        // 3. 调用你的方法
        List<PieChartResult> result = service.getPieChart(testList);

        System.out.println(result);
    }

    public static void GeoChartTest()
    {
        // 1. 准备测试数据
        List<GeoChartDomain> testList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            GeoChartDomain domain = new GeoChartDomain();
            domain.setId(Long.valueOf(i));
            domain.setName("test" + i);
            domain.setType(String.valueOf(i+10));
            domain.setUnit(String.valueOf(i+100));
            testList.add(domain);
            System.out.println(domain);
        }
        // 2. 创建你的服务类实例（假设叫 ChartService）
        GeoChart service = new GeoChart();

        // 3. 调用你的方法
        List<GeoChartResult> result = service.getGeoChart(testList);

        System.out.println(result);
    }
}
