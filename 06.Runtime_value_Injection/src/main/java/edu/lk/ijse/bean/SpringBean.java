package edu.lk.ijse.bean;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SpringBean  {

    @Autowired(required = false)
    public SpringBean(@Value("Achintha")String name,@Value("22")int num) {
        System.out.println(num);
        System.out.println(name);
    }

    @Autowired(required = false)
    public SpringBean(@Value("4444V")String nic[]) throws Exception {
        System.out.println(nic);
    }
//
//    @Override
//    public void afterPropertiesSet() throws Exception {
//        System.out.println(name);
////        output = Achintha
////        valus assign wenne constructor ek cll unata passe
//    }
}
