package edu.lk.ijse.ijse;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestOne implements DI {

//     -----01.propert injection-----
//    @Autowired
//    TestAgreement test;
//
//    public void chatwithTestTwo(){
//        test.chat();
//    }

//   ------ 02.Constructuor Injection-----
//    TestAgreement testAgreement;
//    public TestOne(TestAgreement testAgreement) {
//        this.testAgreement = testAgreement;
//    }
//    public void  chatwithTestTwo(){
//        testAgreement.chat();
//
//    }

//   ----- 03.Setter method injection -------

//    TestAgreement testAgreement;
//    @Autowired
//    public void Setter(TestAgreement testAgreement) {
//        this.testAgreement = testAgreement;
//    }
//    public void  chatwithTestTwo(){
//        testAgreement.chat();
//    }

//   ------------ 04.Interface through Injection--------

    TestAgreement testAgree;
    @Autowired
    @Override
    public void inject(TestAgreement testAgree) {
    this.testAgree = testAgree;
    }
    public void  chatwithTestTwo(){
        testAgree.chat();
    }

}
