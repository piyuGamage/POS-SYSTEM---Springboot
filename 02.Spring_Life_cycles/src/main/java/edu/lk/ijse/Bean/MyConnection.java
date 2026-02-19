package edu.lk.ijse.Bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class MyConnection implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean, DisposableBean {

   public MyConnection() {
       System.out.println("01 *.InitializingBean");
   }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("04  *.BeanFactory aware ");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("03 *.BeanName aware " );

    }

    @Override
    public void destroy() throws Exception {
        System.out.println("07 *.Disposable Bean");

    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("06 *.Bean Initialization");

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("05 *.ApplicationContext");
    }
}
