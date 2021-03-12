package demo_v1.temp.spring.bean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * <p>
 *
 * </p>
 *
 * @author ruixin
 * @date 2020-11-17
 */
@Component
public class CarFactoryBean implements FactoryBean<Car> {

    @Override
    public Car getObject() throws Exception {
        System.err.println("通过FactoryBean-->getObject创建new Car()->bean");
        return new Car();
    }
    @Override
    public Class<?> getObjectType() {
        return Car.class;
    }
    @Override
    public boolean isSingleton() {
        return true;
    }
}
