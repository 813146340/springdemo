import cn.kgc.springdemo.annotation.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotionTest {
    @Test
    public void test(){
        String resource="applicationcontext.xml";
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext(resource);
        UserService userService=applicationContext.getBean("userService", UserService.class);
        userService.addData("武常健");
    }
}
