package demo_v1.temp.spring.bean;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>
 *
 * </p>
 *
 * @author ruixin
 * @date 2020-04-02
 */
@Data
public class Car {

    private String carName;

    private Integer price;


    public Car() {
        System.out.println("Car()...");
    }

    public Car(String carName, Integer price) {
        System.out.println("car construct()...");
        this.carName = carName;
        this.price = price;
    }


//    @Override
//    public String toString() {
//        return "Car{" +
//                "carName='" + carName + '\'' +
//                ", price=" + price +
//                ", testCar=" + testCar +
//                '}';
//    }
}
