package com.soft1851.spring.web.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * @author xunmi
 * @ClassName WebApplicationConfig
 * @Description Web 应用配置，替代之前的 web.xml
 * @Date 2020/3/24
 * @Version 1.0
 **/
public class WebApplicationConfig implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        // 创建一个基于注解的 web 应用的上下文配置对象，实现AnnotationConfigRegistry
        AnnotationConfigWebApplicationContext acac = new AnnotationConfigWebApplicationContext();
        // 将 web MvcConfig 的配置类注册进来
        acac.register(WebMvcConfig.class);
        // 设置 servletContext
        acac.setServletContext(servletContext);
        // 刷新
        acac.refresh();
        // 设置了acac的映射规则
        ServletRegistration.Dynamic registration = servletContext.addServlet("dispatcher", new DispatcherServlet(acac));
        // 添加规则
        registration.addMapping("/");
        // 设置该servlet的启动优先级
        registration.setLoadOnStartup(1);

    }
}
