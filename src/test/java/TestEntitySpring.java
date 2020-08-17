import cn.kgc.springdemo.entity.TestEntity;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestEntitySpring {
    @Test
    public void test(){
        String resource="spring-testentity.xml";
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext(resource);
        TestEntity testEntity=applicationContext.getBean("testEntity",TestEntity.class);
        testEntity.showValue();
    }
}
