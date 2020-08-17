package cn.kgc.springdemo.serverlog;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 增强类
 */
@Aspect
@Component
public class LoggerPrint {
    //定义切点

    /**
     * * cn.kgc.springdemo.annotation.service.*.*(..))")解析
     * execution 中提供的是全限定类名
     * 第一个*空格表示的是所有的返回值类型
     * 上面的意思是扫描service下面所有的类中的所有的方法
     * TODO 可以单独设置 比如某个方法的全限定类名，一定要准确到方法名！
     */
    @Pointcut(value = "execution(* cn.kgc.springdemo.annotation.service.*.*(..))")
    public void printCut(){

    }


    //TODO 所有方法的名字不是固定的，可以随意换，但是一定要起到简明知意的效果

    /**
     * 在目标方法执行前执行
     * @param joinPoint
     */
    @Before(value = "printCut()")
    public void before(JoinPoint joinPoint){
        System.out.println("即将进入"+joinPoint.getSignature().getName()+"方法");
    }

    /**
     * 在目标方法执行后执行
     * @param joinPoint 连接点
     * @param result 目标方法可能会返回一些信息!!! 因为不确定返回啥，所以类型是Object
     */
    @AfterReturning(value = "printCut()",returning = "result")
    public void afterReturning(JoinPoint joinPoint,Object result){
        System.out.println(joinPoint.getSignature().getName()+"执行完成,返回值是"+result);
    }

    @AfterThrowing(pointcut = "printCut()",throwing = "e")
    public void afterThrowing(JoinPoint joinPoint,RuntimeException e){
        System.out.println(joinPoint.getSignature().getName()+"方法在执行的时候发生了错误,内容是"+e.getMessage());
    }

    /**
     * 最终增强，，无论目标方法报不报错，都执行
     */
    @After(value = "printCut()")
    public void after(){
        System.out.println(">>>无论前面发生了什么，我在这里都会执行");
    }

    /**
     * 环绕增强
     * @param jp 和其他的joinpoint 类不一样，这个可以指定目标方法
     */
    public void around(ProceedingJoinPoint jp){
        try {
            //前置增强
            System.out.println("这是环绕增强中的前置增强"+jp.getSignature().getName()+"方法即将执行");
            //这个语句必须要写，否则目标方法不予执行
            Object result=jp.proceed();
            //后置增强
            System.out.println("这是环绕增强的后置增强 目标方法执行完成 未发生异常 返回值是"+result);
        } catch (Throwable throwable) {
            //异常增强
            throwable.printStackTrace();
            System.out.println("目标方法在执行时发生了错误 错误信息是"+throwable.getMessage());
        }finally {
            //最终增强
            System.out.println("这里是环绕增强中的最终增强");
        }
    }
}
