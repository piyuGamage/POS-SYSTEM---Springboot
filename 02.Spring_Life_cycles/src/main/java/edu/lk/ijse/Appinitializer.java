package edu.lk.ijse;

;
import edu.lk.ijse.Bean.MyConnection;
import edu.lk.ijse.Bean.SpringBean;
import edu.lk.ijse.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Appinitializer {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AppConfig.class);
        context.refresh();

        context.getBean(SpringBean.class);
//
//
//        MyConnection myConnection = (MyConnection) context.getBean("ijse");
////        System.out.println(myConnection);
        context.registerShutdownHook();
//        ape jvm eka stop wena welawe moment ekata kalin mokkkd wenne kiyl liyn  puluwn.
    }
}
