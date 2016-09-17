package com.changxx.mvc.framework.mvc;


import com.changxx.mvc.framework.core.HelperLoader;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * 容器监听器
 *
 * @author huangyong
 * @since 1.0
 */
@WebListener
public class ContainerListener implements ServletContextListener {

    /**
     * 当容器初始化时调用
     */
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // 初始化相关 Helper 类
        HelperLoader.init();
    }

    /**
     * 当容器销毁时调用
     */
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }

}