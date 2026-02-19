package Bean;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
@Component("test")
//Bean Scope(Singletan and prototype)

@Scope("prototype")
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE) mehemth prototype cll  krn puluwn
public class SpringBean {
    public SpringBean() {
        System.out.println("SpringBean object created");
    }
    public void printmessage(){
        System.out.println("SpringBean object printed ,,,,,,,,,,,,,,");
    }

}
