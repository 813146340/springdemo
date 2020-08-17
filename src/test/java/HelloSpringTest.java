import cn.kgc.springdemo.hello.HelloSpring;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringTest {
    @Test
    public void Test1(){
        //学习spring之前
        /*HelloSpring helloSpring=new HelloSpring();
        helloSpring.setStr("世界");
        helloSpring.show();*/

        String resource="spring-hello.xml";
        //通过读取配置文件创建容器
        ApplicationContext applicationContext =new ClassPathXmlApplicationContext(resource);
        //通过名字在spring容器中获取相关实例
        HelloSpring helloSpring=applicationContext.getBean("helloSpring",HelloSpring.class);
        helloSpring.show();
    }
}
