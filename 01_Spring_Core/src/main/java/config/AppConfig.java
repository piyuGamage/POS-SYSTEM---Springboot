package config;

import Component.MyConnection;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan(basePackages = "Bean")
@ComponentScan(basePackages = "Component")
public class AppConfig {
    @Bean("ijse")
    @Scope("prototype")
    MyConnection myConnection(){
        return new MyConnection();
    }
}
