package edu.lk.ijse.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

public class SpringBenaTwo implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean, DisposableBean {
    public SpringBenaTwo() {
        System.out.println("tqo.SpringBenaTwo Constructor");
    }
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("tow.BeanFactoryAware");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("tow.BeanNameAware");

    }

    @Override
    public void destroy() throws Exception {
        System.out.println("two.DisposableBean");

    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("two.InitializingBean");

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("two.ApplicationContextAware");

    }
}
