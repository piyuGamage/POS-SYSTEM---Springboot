package edu.lk.ijse.ijse;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class TestTwo implements TestAgreement {
    @Override
    public void chat() {
        System.out.println("TestTwo");
    }
}
