package com.zcct.db.utils;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhaochong
 * @version 1.0
 * @date 2024/8/5 14:49
 * @description:
 */
public class ResultSetUtil {

    /**
     * 将 ResultSet 转换为实体对象列表。
     *
     * @param resultSet ResultSet 对象。
     * @param clazz     实体类的 Class 对象。
     * @param <T>       实体类的泛型类型。
     * @return 实体对象列表。
     * @throws SQLException 如果处理 ResultSet 时出现 SQL 异常。
     * @throws IllegalAccessException 如果访问字段时出现问题。
     * @throws InstantiationException 如果实例化实体类时出现问题。
     */
    public static <T> List<T> convertToEntity(ResultSet resultSet, Class<T> clazz)
            throws SQLException, IllegalAccessException, InstantiationException {

        List<T> entityList = new ArrayList<>();
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();

        while (resultSet.next()) {
            T entity = clazz.newInstance();
            for (int i = 1; i <= columnCount; i++) {
                String columnName = metaData.getColumnName(i);
                Field field = getField(clazz, columnName);
                if (field != null) {
                    Object value = resultSet.getObject(i);
                    field.setAccessible(true);
                    field.set(entity, value);
                }
            }
            entityList.add(entity);
        }

        return entityList;
    }

    /**
     * 获取实体类中的字段。
     *
     * @param clazz     实体类的 Class 对象。
     * @param fieldName 字段名称。
     * @return 字段对象。
     */
    private static Field getField(Class<?> clazz, String fieldName) {
        try {
            return clazz.getDeclaredField(fieldName);
        } catch (NoSuchFieldException e) {
            Class<?> superClass = clazz.getSuperclass();
            if (superClass != null) {
                return getField(superClass, fieldName);
            }
            return null;
        }
    }

    /**
     * 将 ResultSet 转换为 Map。
     *
     * @param resultSet ResultSet 对象。
     * @return Map 对象，其中键是列名，值是列对应的值。
     * @throws SQLException 如果处理 ResultSet 时出现 SQL 异常。
     */
    public static Map<String, String> convertToMap(ResultSet resultSet) throws SQLException {
        Map<String, String> rowMap = new LinkedHashMap<>();
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();

        if (resultSet.next()) {
            for (int i = 1; i <= columnCount; i++) {
                String columnName = metaData.getColumnName(i);
                String columnValue = resultSet.getString(i);
                rowMap.put(columnName, columnValue);
            }
        }

        return rowMap;
    }

    /**
     * 将 ResultSet 转换为 List<Map<String, Object>>。
     *
     * @param resultSet ResultSet 对象。
     * @return List<Map<String, Object>> 对象，其中每个 Map 表示 ResultSet 中的一行数据。
     * @throws SQLException 如果处理 ResultSet 时出现 SQL 异常。
     */
    public static List<Map<String, String>> convertToMapList(ResultSet resultSet) throws SQLException {
        List<Map<String, String>> resultList = new ArrayList<>();
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();

        while (resultSet.next()) {
            Map<String, String> rowMap = new LinkedHashMap<>();
            for (int i = 1; i <= columnCount; i++) {
                String columnName = metaData.getColumnName(i);
                String columnValue = resultSet.getString(i);
                rowMap.put(columnName, columnValue);
            }
            resultList.add(rowMap);
        }

        return resultList;
    }
}
