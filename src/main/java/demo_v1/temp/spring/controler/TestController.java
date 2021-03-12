package demo_v1.temp.spring.controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * <p>
 *   controller
 * </p>
 *
 * @author ruixin
 * @date 2020-04-11
 */
@Controller
public class TestController {


    @GetMapping("/index.do")
    public void test(){
        System.out.println("test controller ...");
    }
}
