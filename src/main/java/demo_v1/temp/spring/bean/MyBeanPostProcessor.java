package demo_v1.temp.spring.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * <p>
 *
 * </p>
 *
 * @author ruixin
 * @date 2020-04-05
 */
//@Component
public class MyBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if(beanName.equals("car")){
            System.out.println("MyBeanPostProcessor--postProcessBeforeInitialization()");
            return bean;
        }
        return bean;

    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(beanName.equals("car")){
            System.out.println("MyBeanPostProcessor--postProcessAfterInitialization()");
            return bean;
        }
        return bean;
    }
}
