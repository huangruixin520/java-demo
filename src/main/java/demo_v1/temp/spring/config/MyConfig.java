package demo_v1.temp.spring.config;

import demo_v1.temp.spring.bean.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * <p>
 *  spring.xml  配置文件类
 * </p>
 *
 * @author ruixin
 * @date 2020-04-02
 */
@Configuration
@ComponentScan(value = "demo_v1.temp.spring")
public class MyConfig {


//    @Bean
//    public Car car(){
//        return new Car();
//    }

}
