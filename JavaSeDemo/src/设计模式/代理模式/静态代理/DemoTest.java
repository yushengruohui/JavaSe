package 设计模式.代理模式.静态代理;

import org.junit.Test;

/**
 * @author: yusheng
 * @create-date: 2019-12-20 09:59
 **/
public class DemoTest {
    @Test
    public void demo1() {
        ISource source = new ProxyHandler();
        int i = source.addUser();
    }

}
