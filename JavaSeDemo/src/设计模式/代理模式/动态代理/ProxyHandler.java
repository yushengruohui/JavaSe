package 设计模式.代理模式.动态代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 代理类
 *
 * @author: yusheng
 * @create-date: 2019-12-20 21:37
 **/
public class ProxyHandler implements InvocationHandler {
    private Object source;

    ProxyHandler() {
        this.source = new Source();
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("我是代理类，委托类太懒了，我帮他执行一下方法");
        System.out.println("==========代理开始");
        // 执行委托类的方法
        Object result = method.invoke(source, args);
        System.out.println("代理结束============");
        return result;
    }
}
