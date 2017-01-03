package es.didiez;

import static es.didiez.IndexBean.BEAN_NAME;
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
    private final ConfigurableListableBeanFactory context;
    private int count = 0;    
    
    public IndexBean(ConfigurableListableBeanFactory context) {
        System.out.println("IndexBean constructor");
        this.context = context;
    }
    
    public String hello(){
        System.out.println("SCOPE --> " + context.getBeanDefinition(BEAN_NAME).getScope());
        if(!"request".equals(context.getBeanDefinition(BEAN_NAME).getScope())){
            throw new IllegalStateException(BEAN_NAME + " must be request scope");
        }
        if(count++ != 0) {
            throw new IllegalStateException(BEAN_NAME + " not being a real request scope bean (persistent state across requests)");
        }
        return "Hello World!";
    }
    
}
