package com.zcct.db;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 赵冲
 * @description
 * @date 2023/3/1
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    DynamicDataSourceProvider dynamicDataSourceProvider;

    public DynamicDataSource(DynamicDataSourceProvider dynamicDataSourceProvider) {
        this.dynamicDataSourceProvider = dynamicDataSourceProvider;
        Map<Object, Object> targetDataSources = new HashMap<>(dynamicDataSourceProvider.loadDataSources());
        super.setTargetDataSources(targetDataSources);
        super.setDefaultTargetDataSource(targetDataSources.get(DynamicDataSourceProvider.DEFAULT_DATASOURCE));
        super.afterPropertiesSet();
    }

    @Override
    protected Object determineCurrentLookupKey() {
        String dataSourceType = DynamicDataSourceContextHolder.peek();
        return dataSourceType;
    }
}
