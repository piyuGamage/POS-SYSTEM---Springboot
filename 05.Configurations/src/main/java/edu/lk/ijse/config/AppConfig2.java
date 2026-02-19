package edu.lk.ijse.config;

import edu.lk.ijse.bean.B;
import edu.lk.ijse.bean.C;
import edu.lk.ijse.bean.D;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig2 {

    @Bean
    public C c() {
        return new C();
    }
    @Bean
    public D d() {
        return new D();
    }
}
