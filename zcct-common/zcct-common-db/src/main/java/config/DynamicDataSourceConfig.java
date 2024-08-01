package config;

/**
 * @author zhaochong
 * @version 1.0
 * @date 2024/8/1 16:05
 * @description:
 */
public class DynamicDataSourceConfig {

//    @Autowired
//    private DataSourcePropertiesService dataSourcePropertiesService;
//
//    @Bean
//    public DataSource dynamicDataSource() {
//        DynamicDataSource dataSource = new DynamicDataSource();
//        dataSource.setTargetDataSources(dataSourcePropertiesService.getDataSourceMap());
//        dataSource.setDefaultTargetDataSource(dataSourcePropertiesService.getDefaultDataSource());
//        return dataSource;
//    }

    // DynamicDataSource继承自AbstractRoutingDataSource，用于动态切换数据源
//    public static class DynamicDataSource extends AbstractRoutingDataSource {
//        @Override
//        protected Object determineCurrentLookupKey() {
//            // 根据业务逻辑确定当前线程应使用哪个数据源
//            return DataSourceContextHolder.getDataSourceName();
//        }
//    }

}
