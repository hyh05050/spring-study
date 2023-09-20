package hello.core.autowired;

import hello.core.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutoWiredTest {

    @Test
    void AutowiredOption() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
        System.out.println("AutoWiredTest.AutowiredOption = " + ac.getBean(TestBean.class));
    }


    static class TestBean {

        @Autowired(required = false) //자동주입 대상이 없으면 호출이 안됨
        public void setNoBean1(Member member) {
            System.out.println("TestBean.setNoBean1");
        }

        @Autowired //자동주입 대상이 없으면 null
        public void setNoBean2(@Nullable Member member) {
            System.out.println("TestBean.setNoBean2 = "+member);
        }

        @Autowired //자동주입 대상이 없으면 Optional.empty
        public void setNoBean3(Optional<Member> member) {
            System.out.println("TestBean.setNoBean3 = "+member);
        }
    }
}
