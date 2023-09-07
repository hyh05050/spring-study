package hello.core.beanfind;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력")
    void findAllBean() {
        String[] beadDefinitionsNames = ac.getBeanDefinitionNames();
        for(String name : beadDefinitionsNames) {
            Object bean = ac.getBean(name);
            System.out.println("name="+name+" object="+bean);
        }
    }

    @Test
    @DisplayName("모든 빈 출력")
    void findApplicationBean() {
        String[] beadDefinitionsNames = ac.getBeanDefinitionNames();
        for(String name : beadDefinitionsNames) {
            BeanDefinition bd = ac.getBeanDefinition(name);

            //ROLE_APPLICATION 직접 등록한 빈
            //ROLE_INFRASTRUCTURE 스프링 내부용 빈
            if(bd.getRole() == bd.ROLE_APPLICATION) {
                Object bean = ac.getBean(name);
                System.out.println("name="+name+" object="+bean);
            }
        }
    }
}
