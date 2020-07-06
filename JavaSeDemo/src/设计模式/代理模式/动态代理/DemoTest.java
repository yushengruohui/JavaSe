package 设计模式.代理模式.动态代理;

import org.junit.Test;

import java.lang.reflect.Proxy;

/**
 * 测试案例
 *
 * @author: yusheng
 * @create-date: 2019-12-20 09:59
 **/
public class DemoTest {
    @Test
    public void demo1() {
        // 我们要代理的真实对象
        ProxyHandler proxyhandler = new ProxyHandler();
        // 传入 委托类的类加载器，委托类的所有方法，代理类，就可以生成动态代理对象 ，如果动态代理对象有被调用，则执行代理类的方法。
        ISource result = (ISource) Proxy.newProxyInstance(Source.class.getClassLoader(), Source.class.getInterfaces(), proxyhandler);
        result.addUser();
    }

}
