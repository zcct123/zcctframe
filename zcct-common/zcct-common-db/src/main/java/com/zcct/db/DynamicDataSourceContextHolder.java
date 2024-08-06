package com.zcct.db;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.NamedThreadLocal;
import org.springframework.util.StringUtils;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author 赵冲
 * @description
 * @date 2023/3/1
 */
@Slf4j
public class DynamicDataSourceContextHolder {

    private static final ThreadLocal<Deque<String>> LOOKUP_KEY_HOLDER = new NamedThreadLocal<Deque<String>>("dynamic-datasource") {

        protected Deque<String> initialValue() {
            return new ArrayDeque();
        }
    };

    private DynamicDataSourceContextHolder() {
    }

    public static String peek() {
        return (String)((Deque)LOOKUP_KEY_HOLDER.get()).peek();
    }

    public static String push(String ds) {
        log.info("切换到{}数据源", ds);
        String dataSourceStr = StringUtils.isEmpty(ds) ? "" : ds;
        ((Deque)LOOKUP_KEY_HOLDER.get()).push(dataSourceStr);
        return dataSourceStr;
    }

    public static void poll() {
        Deque<String> deque = (Deque)LOOKUP_KEY_HOLDER.get();
        deque.poll();
        if (deque.isEmpty()) {
            LOOKUP_KEY_HOLDER.remove();
        }

    }

    public static void clear() {
        LOOKUP_KEY_HOLDER.remove();
    }
}
