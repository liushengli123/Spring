package com.SpringAOP;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.stereotype.Component;

@Component("myAspectj")
@Aspect
public class MyAspectj {
    @Before("pointcut()")
    public void before(){
        System.out.println("this is 前置通知");
    }
    @AfterReturning("pointcut()")
    public void afterReturn(){
        System.out.println("this is 后置通知");
    }
    @Around("execution(* com.SpringAOP.Target.*(..)))")
    public Object  around(ProceedingJoinPoint pjb) throws Throwable {
        System.out.println("this is 环绕通知");
        Object proceed = pjb.proceed();
        System.out.println("this is 环绕通知");
        return proceed;
    }
    @After("execution(* com.SpringAOP.Target.*(..)))")
    public void after(){
        System.out.println("this is 最终通知");
    }
    @AfterThrowing("execution(* com.SpringAOP.Target.*(..)))")
    public void afterThrowing(){
        System.out.println("this is 异常通知");
    }
    @Pointcut("execution(* com.SpringAOP.Target.*(..)))")
    public void pointcut(){};
}
