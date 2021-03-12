package demo_v1.temp.spring.tomcat;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

import javax.servlet.ServletException;

/**
 * <p>
 *  自定义Tomcat
 * </p>
 *
 * @author ruixin
 * @date 2020-04-11
 */
public class StartTomcat {
    public static void main(String[] args) {
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);
        try {
            //context:访问地址路项目径   baseDir：项目磁盘地址
            tomcat.addWebapp("/","/Users/ruixin/IdeaProjects/mycode/java-demo/src/main/java/demo_v1/temp/spring");
            //启动tomcat
            tomcat.start();
            //阻塞tomcat
            tomcat.getServer().await();
        } catch (LifecycleException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }
}
