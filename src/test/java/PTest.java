import cn.kgc.springdemo.entity.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PTest {
    @Test
    public void test(){
        String resource="spring-p.xml";
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext(resource);
        User user=applicationContext.getBean("user", User.class);
        System.out.println(user);
    }
}
