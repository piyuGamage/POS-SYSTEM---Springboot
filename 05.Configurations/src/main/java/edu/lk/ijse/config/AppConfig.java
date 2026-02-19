package edu.lk.ijse.config;


import org.springframework.context.annotation.*;

@Configuration
@ComponentScan(basePackages = "edu.lk.ijse.bean ")
@Import({AppConfig1.class, AppConfig2.class})
@ImportResource("classpath:hibernate.cfg.xml")
public class AppConfig {

//   Multiple configuration - better to use enhance the separation of concerns
//   DB Bean = DBConfig
//   Seacurity Bean - seacurityConfig
//   Business Logic Bean - BSConfig

}
