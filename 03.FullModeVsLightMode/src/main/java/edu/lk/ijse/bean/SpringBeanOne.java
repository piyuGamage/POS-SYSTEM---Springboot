package edu.lk.ijse.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

public class SpringBeanOne implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean, DisposableBean {

    public SpringBeanOne() {
        System.out.println("SpringBeanOne Constructor");
    }
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println(".BeanFactoryAware");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println(".BeanNameAware");

    }

    @Override
    public void destroy() throws Exception {
        System.out.println(".DisposableBean");

    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(".InitializingBean");

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println(".ApplicationContextAware");

    }
}
