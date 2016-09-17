package com.changxx.mvc.framework.core;


import com.changxx.mvc.framework.core.util.ClassUtil;
import com.changxx.mvc.framework.ioc.BeanHelper;
import com.changxx.mvc.framework.ioc.IocHelper;
import com.changxx.mvc.framework.mvc.ActionHelper;

/**
 * 加载相应的 Helper 类
 */
public final class HelperLoader {

    public static void init() {
        // 定义需要加载的 Helper 类
        Class<?>[] classList = {
                ActionHelper.class,
                BeanHelper.class,
                IocHelper.class,
        };
        // 按照顺序加载类
        for (Class<?> cls : classList) {
            ClassUtil.loadClass(cls.getName());
        }
    }
}
