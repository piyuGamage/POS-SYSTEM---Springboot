package edu.lk.ijse.Bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")

public class SpringBean implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean, DisposableBean {

    public SpringBean() {
        System.out.println("01.Instantiton");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("04.BeanFactory aware " + beanFactory);
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("03.BeanName aware " + name);

    }

    @Override
    public void destroy() throws Exception {
        System.out.println("07.Disposable Bean");

    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("06..Bean Initialization");

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("05.ApplicationContext");
    }
}
