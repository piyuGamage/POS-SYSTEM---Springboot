package edu.lk.ijse.bean;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SpringBean implements InitializingBean {

    @Value("${db.name}")
    private String dbName;
    @Value("${db.user}")
    private String dbUser;
    @Value("${db.password}")
    private String dbPassword;
    @Value("${db.url}")
    private String dbURL;

    public SpringBean() {
        System.out.println("SpringBean object created ... !");
        System.out.println(dbName);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(dbName);
        System.out.println(dbUser);
        System.out.println(dbPassword);
        System.out.println(dbURL);
    }

}
