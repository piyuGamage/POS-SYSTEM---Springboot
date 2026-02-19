import Bean.SpringBean;
import Component.Componentbean;
import Component.MyConnection;
import config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Appinitializer {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AppConfig.class);
        context.refresh();

        SpringBean springBean = (SpringBean) context.getBean("test");
        SpringBean springBean2 = (SpringBean) context.getBean("test");
        System.out.println(springBean);
        System.out.println(springBean2);

        Componentbean componentbean = context.getBean(Componentbean.class);
        System.out.println(componentbean);

        MyConnection myConnection = (MyConnection) context.getBean("ijse");
        System.out.println(myConnection);
        context.registerShutdownHook();
//        ape jvm eka stop wena welawe moment ekata kalin mokkkd wenne kiyl liyn  puluwn.
    }
}
