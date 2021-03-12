package demo_v1.temp.spring;

import demo_v1.temp.spring.config.MyConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>
 * SpringIOC容器
 * </p>
 *
 * @author ruixin
 * @date 2020-04-02
 */
public class SpringContextDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        Object bean = context.getBean("carFactoryBean");
        System.out.println(bean);


        ReentrantLock lock = new ReentrantLock();


    }
}
