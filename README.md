# EChartsTools
供后端开发者使用的数据结构转换工具箱，主要是将业务对象转换成前端可直接使用ECharts数据结构


# 使用教程
## 一、LineChart使用教程
注：LineDataSupplier是以线为单位的接口，LineChartDataSupplier是以整个图表为单位的接口
### 1、业务实体实现LineChartDataSupplier的接口，但是定义每条线的信息如果都写在这个业务实体中，代码会非常臃肿，并且可读性与维护性差。
### 解决办法是：自己创建一个以线为单位的对象，实现LineDataSupplier接口，然后在业务实体中，通过新建对象的构造函数，动态的实现LineChartDataSupplier接口
### 例子：业务实体（LineChartDomain）、新建对象（SmallestLineDomain）
