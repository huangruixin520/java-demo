package demo_v1.temp.spring.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * <p>
 *
 * </p>
 *
 * @author ruixin
 * @date 2020-11-16
 */
@Component
public class ServiceA {

//    @Autowired
//    Car car;

    public ServiceA() {
        System.out.println("ServiceA()...");
    }
}
