package edu.lk.ijse.Bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class Boy implements   BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean, DisposableBean {
//    properti Injection
    @Autowired
        @Qualifier("girl")
    Agreement agreement;
    // @Autowired-dependacny ekak ijection karaganna puluwn- kiyana eken new key word eka use karn nthuw object ekak hadganna pulun.
    //methndi new keyword eka dala haduwama object eka depark create wenw grils constructor eka depark cll wenw,new girl eka ain karala Girl girl; mehem dala hduwam nul pont exception ekak enw new object ekak hadapu nthi nisa..

    public void chatWithGirl(){
//        Construtor true injection
//        Girl girl = new Girl();
        agreement.chat();
    }

    public Boy(){
        System.out.println("boy Object Created ");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
//        System.out.println(".BeanFactoryAware");
    }

    @Override
    public void setBeanName(String name) {
//        System.out.println(".BeanNameAware");

    }

    @Override
    public void destroy() throws Exception {
//        System.out.println(".DisposableBean");

    }

    @Override
    public void afterPropertiesSet() throws Exception {
//        System.out.println(".InitializingBean");

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
//        System.out.println(".ApplicationContextAware");

    }
}
