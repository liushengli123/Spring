package com.jdkAOP;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//基于jdk的动态代理实现方法
public class JdkTest {
    public static void main(String[] args) {
        final Targit targit=new Targit();
        final Advice advice = new Advice();
        //返回值就是生成的动态代理对象
        TargitInterface proxy = (TargitInterface) Proxy.newProxyInstance(
                targit.getClass().getClassLoader(),//目标对象的类加载器
                targit.getClass().getInterfaces(),//目标对象的相同字节码数组
                new InvocationHandler() {
                    //调用代理对象的任何方法 实际执行的都是invoke方法
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        advice.before();//前置增强
                        Object invoke = method.invoke(targit, args);//执行目标方法
                        advice.after();//后置增强
                        return invoke;
                    }
                }
        );
        //调用代理对象的方法
        proxy.save();
    }
}
