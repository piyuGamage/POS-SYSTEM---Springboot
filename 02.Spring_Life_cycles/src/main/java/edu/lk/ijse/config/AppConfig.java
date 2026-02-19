package edu.lk.ijse.config;


import edu.lk.ijse.Bean.MyConnection;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan(basePackages = "edu.lk.ijse.Bean")
//@ComponentScan(basePackages = "edu.lk.ijse.Component")
public class AppConfig {
    @Bean
    MyConnection myConnection(){
        return new MyConnection();
    }
}
