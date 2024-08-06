package com.zcct.db;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.zcct.db.config.DruidProperties;
import com.zcct.db.entity.SysDatasource;
import com.zcct.db.utils.ResultSetUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author 赵冲
 * @description
 * @date 2023/3/1
 */
@Configuration
@EnableConfigurationProperties(DruidProperties.class)
public class DynamicDataSourceProvider {

    public static String DEFAULT_DATASOURCE = "master";
    public static String BASE_DATASOURCE = "base";

    private static String QUERY_SOURCE_SQL = " select * from sys_datasource ";

    @Autowired
    DruidProperties druidProperties;

    @Autowired
    DruidDataSource druidDataSource;

    public Map<String,  DataSource> loadDataSources() {

        Map<String, DataSource> ds = new HashMap<>();

        druidDataSource.setName(BASE_DATASOURCE);
        ds.put(BASE_DATASOURCE, druidDataSource);

        Map<String, Map<String, String>> businessDataSource = getBusinessDataSource();

        try {
            Set<String> keySet = businessDataSource.keySet();
            for (String s : keySet) {
                DruidDataSource dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(businessDataSource.get(s));
                ds.put(s, druidProperties.dataSource(dataSource));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ds;
    }

    private Map<String, Map<String, String>> getBusinessDataSource() {

        List<Map<String, String>> list = new ArrayList<>();

        try(Connection connection = druidDataSource.getConnection();
            Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(QUERY_SOURCE_SQL);

            list = ResultSetUtil.convertToMapList(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return list.stream().collect(Collectors.toMap(item -> item.get("type"), Function.identity()));
    }
}
