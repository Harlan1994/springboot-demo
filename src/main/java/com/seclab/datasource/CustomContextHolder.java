package com.seclab.datasource;

/**
 * Created with IntelliJ IDEA.
 * User: harlan
 * Date: 2018/4/4
 * Time: 09:40
 * Description:
 */
public class CustomContextHolder {

    public static final String DATA_SOURCE_MASTER = "data_source_master";
    public static final String DATA_SOURCE_SLAVER = "data_source_slaver";

    public static final ThreadLocal<String> contextHolder = new ThreadLocal<>();

    public static void setDataSource(String type) {
        contextHolder.set(type);
    }

    public static String getDataSource() {
        return contextHolder.get();
    }

    public static void clearDataSource() {
        contextHolder.remove();
    }
}
