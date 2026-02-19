package edu.lk.ijse.config;


import edu.lk.ijse.bean.SpringBeanOne;
import edu.lk.ijse.bean.SpringBenaTwo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "edu.lk.ijse.bean")
public class AppConfig {
//Fully Mode
//    @Bean
//    public SpringBenaTwo springBenaTwo() {
//        return new SpringBenaTwo();
//    }
//

//    @Bean
//    public SpringBeanOne springBeanOne() {
//        //Interbean dependancy (bean ekak athule bean ekak)
//        SpringBenaTwo springBenaTwo = SpringBenaTwo();
//        SpringBenaTwo springBenaTwo1 = SpringBenaTwo();
//        System.out.println(springBenaTwo1);
//        System.out.println(springBenaTwo);
//        return new SpringBeanOne();
//    }

}
