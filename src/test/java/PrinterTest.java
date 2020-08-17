import cn.kgc.springdemo.printer.SuperPrinter;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PrinterTest {
    @Test
    public void test(){
        String resource="spring-printer.xml";
        ApplicationContext applicationContext =new ClassPathXmlApplicationContext(resource);
        SuperPrinter superPrinter=applicationContext.getBean("printer", SuperPrinter.class);
        superPrinter.print();
    }
}
