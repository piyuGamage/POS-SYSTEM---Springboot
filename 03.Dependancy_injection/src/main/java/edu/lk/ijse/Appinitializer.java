package edu.lk.ijse;

import edu.lk.ijse.Bean.Boy;
import edu.lk.ijse.Bean.Girl;
import edu.lk.ijse.config.AppConfig;
import edu.lk.ijse.ijse.TestOne;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Appinitializer {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AppConfig.class);
        context.refresh();
//        context.getBean(Boy.class);
//        Boy boy = context.getBean(Boy.class);
//        System.out.println(context.getBean(Boy.class));
//        System.out.println(context.getBean(Girl.class));
//        boy.chatWithGirl();
//        Girl girl = context.getBean(Girl.class);
//        girl.chat();

        TestOne test = context.getBean(TestOne.class);
        test. chatwithTestTwo();
        context.registerShutdownHook();
    }
}