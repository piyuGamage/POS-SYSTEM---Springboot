package edu.lk.ijse;

import edu.lk.ijse.config.AppConfig;
import edu.lk.ijse.config.AppConfig1;
import edu.lk.ijse.config.AppConfig2;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Appinitializer {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AppConfig.class);
//        context.register(AppConfig1.class);
//        context.register(AppConfig2.class);
        context.refresh();


        context.registerShutdownHook();
    }
}