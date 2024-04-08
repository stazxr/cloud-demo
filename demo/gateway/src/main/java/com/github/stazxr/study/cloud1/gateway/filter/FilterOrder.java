package com.github.stazxr.study.cloud1.gateway.filter;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class FilterOrder {
    private FilterOrder() {
        throw new IllegalStateException("Utility class");
    }

    protected static final Map<Class<?>, Integer> FILTER_ORDERS;

    static {
        Map<Class<?>, Integer> map = new HashMap<>();

        // 登录状态校验
        map.put(AuthenticationFilter.class, Integer.MAX_VALUE);

        FILTER_ORDERS = Collections.unmodifiableMap(map);
    }
}
