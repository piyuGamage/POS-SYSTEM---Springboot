package edu.lk.ijse.config;

import edu.lk.ijse.bean.A;
import edu.lk.ijse.bean.B;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig1 {
@Bean
    public A a() {
    return new A();
}
@Bean
    public B b() {
    return new B();
}
}
