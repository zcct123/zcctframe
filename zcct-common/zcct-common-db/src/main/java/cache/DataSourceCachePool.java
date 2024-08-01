package cache;

import com.alibaba.druid.pool.DruidDataSource;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhaochong
 * @version 1.0
 * @date 2024/8/1 15:58
 * @description:
 */
public class DataSourceCachePool {

    /** 数据源连接池缓存【本地 class缓存 - 不支持分布式】 */
    private static Map<String, DruidDataSource> dbSources = new HashMap<>();

    /**
     * 获取多数据源缓存
     *
     * @param dbKey
     * @return
     */
//    public static DynamicDataSourceModel getCacheDynamicDataSourceModel(String dbKey) {
//        String redisCacheKey = ConfigConstant.SYS_DYNAMICDB_CACHE + dbKey;
//        if (getRedisTemplate().hasKey(redisCacheKey)) {
//            String model = (String)getRedisTemplate().opsForValue().get(redisCacheKey);
//            return  JSON.parseObject(model,DynamicDataSourceModel.class);
//        }
//        DatasourceDao datasourceDao = (DatasourceDao)SpringContextUtils.getBean("datasourceDao");
//        DynamicDataSourceModel dbSource = datasourceDao.getDynamicDbSourceByCode(dbKey);
//        try{
//            dbSource.setDbPassword(AesUtil.decryptBySalt(dbSource.getDbPassword(),dbSource.getId()));
//        }catch (Exception e){
//            throw new RRException("动态数据源密钥解密失败，dbKey："+dbKey);
//        }
//
//        if (dbSource != null) {
//            getRedisTemplate().opsForValue().set(redisCacheKey, JSONObject.toJSONString(dbSource));
//        }
//        return dbSource;
//    }

    public static DruidDataSource getCacheBasicDataSource(String dbKey) {
        return dbSources.get(dbKey);
    }

    /**
     * put 数据源缓存
     *
     * @param dbKey
     * @param db
     */
    public static void putCacheBasicDataSource(String dbKey, DruidDataSource db) {
        dbSources.put(dbKey, db);
    }
}
