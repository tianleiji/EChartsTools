package com.echarts.tool.check;

import com.echarts.tool.exception.InvalidYAxisValueException;

public class Convert {

    /**
     * @param obj 业务对象中，通过反射获取某个字段下的object
     * @return Byte类型
     */
    public static Number parseByteNumber(Object obj){
        if (obj == null) return 0;
        if (obj instanceof Number) return (Number) obj;
        if (obj instanceof String) {
            String s = ((String) obj).trim();
            if (s.isEmpty()) return 0;
            try {
                return Byte.parseByte(s);
            } catch (NumberFormatException e) {
                throw new InvalidYAxisValueException(obj.getClass());
            }
        }
        throw new IllegalArgumentException("Unsupported type for Byte: " + obj.getClass());
    }

    /**
     * @param obj 业务对象中，通过反射获取某个字段下的object
     * @return Integer类型
     */
    public static Number parseIntegerNumber(Object obj){
        if (obj == null) return 0;
        if (obj instanceof Number) return (Number) obj;
        if (obj instanceof String) {
            String s = ((String) obj).trim();
            if (s.isEmpty()) return 0;
            try {
                return Integer.parseInt(s);
            } catch (NumberFormatException e) {
                throw new InvalidYAxisValueException(obj.getClass());
            }
        }
        throw new IllegalArgumentException("Unsupported type for Integer: " + obj.getClass());
    }

    /**
     * @param obj 业务对象中，通过反射获取某个字段下的object
     * @return Long类型
     */
    public static Number parseLongNumber(Object obj){
        if (obj == null) return 0;
        if (obj instanceof Number) return (Number) obj;
        if (obj instanceof String) {
            String s = ((String) obj).trim();
            if (s.isEmpty()) return 0;
            try {
                return Long.parseLong(s);
            } catch (NumberFormatException e) {
                throw new InvalidYAxisValueException(obj.getClass());
            }
        }
        throw new IllegalArgumentException("Unsupported type for Long: " + obj.getClass());
    }

    /**
     * @param obj 业务对象中，通过反射获取某个字段下的object
     * @return Float类型
     */
    public static Number parseFloatNumber(Object obj) {
        if (obj == null) return 0;
        if (obj instanceof Number) return (Number) obj;
        if (obj instanceof String) {
            String s = ((String) obj).trim();
            if (s.isEmpty()) return 0;
            try {
                return Float.parseFloat(s);
            } catch (NumberFormatException e) {
                throw new InvalidYAxisValueException(obj.getClass());
            }
        }
        throw new IllegalArgumentException("Unsupported type for Float: " + obj.getClass());
    }

    /**
     * @param obj 业务对象中，通过反射获取某个字段下的object
     * @return Double类型
     */
    public static Number parseDoubleNumber(Object obj) {
        if (obj == null) return 0;
        if (obj instanceof Number) return (Number) obj;
        if (obj instanceof String) {
            String s = ((String) obj).trim();
            if (s.isEmpty()) return 0;
            try {
                return Double.parseDouble(s);
            } catch (NumberFormatException e) {
                throw new InvalidYAxisValueException(obj.getClass());
            }
        }
        throw new IllegalArgumentException("Unsupported type for Double: " + obj.getClass());
    }
}
