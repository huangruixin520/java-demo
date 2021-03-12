package demo_v1.temp.spring.bean;

import org.springframework.context.annotation.Scope;
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
@Scope("prototype")
public class ServiceB {

    public ServiceB() {
        System.out.println("ServiceB()...");
    }
}
