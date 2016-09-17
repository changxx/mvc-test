package com.changxx.mvc.framework.core;


import com.changxx.mvc.framework.core.impl.DefaultClassScanner;
import com.changxx.mvc.framework.core.util.ObjectUtil;
import com.changxx.mvc.framework.core.util.StringUtil;
import com.changxx.mvc.framework.mvc.HandlerInvoker;
import com.changxx.mvc.framework.mvc.HandlerMapping;
import com.changxx.mvc.framework.mvc.ViewResolver;
import com.changxx.mvc.framework.mvc.impl.DefaultHandlerInvoker;
import com.changxx.mvc.framework.mvc.impl.DefaultHandlerMapping;
import com.changxx.mvc.framework.mvc.impl.DefaultViewResolver;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 实例工厂
 */
public class InstanceFactory {

    /**
     * 用于缓存对应的实例
     */
    private static final Map<String, Object> cache = new ConcurrentHashMap<String, Object>();

    /**
     * ClassScanner
     */
    private static final String CLASS_SCANNER = "smart.framework.custom.class_scanner";

    /**
     * HandlerMapping
     */
    private static final String HANDLER_MAPPING = "smart.framework.custom.handler_mapping";

    /**
     * HandlerInvoker
     */
    private static final String HANDLER_INVOKER = "smart.framework.custom.handler_invoker";

    /**
     * HandlerExceptionResolver
     */
    private static final String HANDLER_EXCEPTION_RESOLVER = "smart.framework.custom.handler_exception_resolver";

    /**
     * ViewResolver
     */
    private static final String VIEW_RESOLVER = "smart.framework.custom.view_resolver";

    /**
     * 获取 ClassScanner
     */
    public static ClassScanner getClassScanner() {
        return getInstance(CLASS_SCANNER, DefaultClassScanner.class);
    }

    /**
     * 获取 HandlerMapping
     */
    public static HandlerMapping getHandlerMapping() {
        return getInstance(HANDLER_MAPPING, DefaultHandlerMapping.class);
    }

    /**
     * 获取 HandlerInvoker
     */
    public static HandlerInvoker getHandlerInvoker() {
        return getInstance(HANDLER_INVOKER, DefaultHandlerInvoker.class);
    }

    /**
     * 获取 ViewResolver
     */
    public static ViewResolver getViewResolver() {
        return getInstance(VIEW_RESOLVER, DefaultViewResolver.class);
    }


    @SuppressWarnings("unchecked")
    public static <T> T getInstance(String cacheKey, Class<T> defaultImplClass) {
        // 若缓存中存在对应的实例，则返回该实例
        if (cache.containsKey(cacheKey)) {
            return (T) cache.get(cacheKey);
        }
        // 从配置文件中获取相应的接口实现类配置
        String implClassName = ConfigHelper.getString(cacheKey);
        // 若实现类配置不存在，则使用默认实现类
        if (StringUtil.isEmpty(implClassName)) {
            implClassName = defaultImplClass.getName();
        }
        // 通过反射创建该实现类对应的实例
        T instance = ObjectUtil.newInstance(implClassName);
        // 若该实例不为空，则将其放入缓存
        if (instance != null) {
            cache.put(cacheKey, instance);
        }
        // 返回该实例
        return instance;
    }
}
