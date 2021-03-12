package demo_v1.temp.spring.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

/**
 * <p>
 *   web.xml  tomcat启动之后会调用onStartup()方法
 * </p>
 *
 * @author ruixin
 * @date 2020-04-11
 */
public class MyWebApplicationInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletCxt) {
        // 1、加载spring容器
        System.out.println("加载spring容器...");
        AnnotationConfigWebApplicationContext ac = new AnnotationConfigWebApplicationContext();
        //注册spring的配置类
        ac.register(MyConfig.class);
        ac.refresh();

        // 2、创建并注册DispatcherServlet
        System.out.println("创建并注册DispatcherServlet...");
        DispatcherServlet servlet = new DispatcherServlet(ac);
        ServletRegistration.Dynamic registration = servletCxt.addServlet("app", servlet);
        registration.addMapping("/*");
        registration.setLoadOnStartup(1);
    }
}
