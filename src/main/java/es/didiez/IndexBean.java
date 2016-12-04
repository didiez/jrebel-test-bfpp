package es.didiez;

import static es.didiez.IndexBean.BEAN_NAME;
import java.util.stream.Stream;
import javax.enterprise.context.RequestScoped;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 *
 * @author diego
 */
@Component(BEAN_NAME)
@RequestScoped
public class IndexBean {

    public static final String BEAN_NAME = "indexBean";
    
    public IndexBean(ConfigurableListableBeanFactory context) {
        if(!"request".equals(context.getBeanDefinition(BEAN_NAME).getScope())){
            throw new IllegalStateException(BEAN_NAME + " must be request scope");
        }
    }
    
    public String hello(){
        return "Hello World!";
    }   
    
}
