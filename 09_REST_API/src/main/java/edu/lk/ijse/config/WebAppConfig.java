package edu.lk.ijse.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan(basePackages = "edu.lk.ijse.Controller")
@EnableWebMvc
public class WebAppConfig implements WebMvcConfigurer {
}
