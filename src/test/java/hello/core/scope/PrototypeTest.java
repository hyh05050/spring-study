package hello.core.scope;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class PrototypeTest {

    @Test
    void prototypeBeanFind() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean.class);

        PrototypeBean sb1 = ac.getBean(PrototypeBean.class);
        PrototypeBean sb2 = ac.getBean(PrototypeBean.class);
        Assertions.assertThat(sb1).isNotSameAs(sb2);

        ac.close();

        sb1.destroy();
        sb2.destroy();


    }

    @Scope("prototype")
    static class PrototypeBean {
        @PostConstruct
        public void init() {
            System.out.println("PrototypeBean Init");
        }

        @PreDestroy
        public void destroy() {
            System.out.println("PrototypeBean Destroy");
        }
    }
}
