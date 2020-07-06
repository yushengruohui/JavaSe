package 设计模式.原型模式;

import org.junit.Test;

/**
 * @author: yusheng
 * @create-date: 2019-12-20 09:59
 **/
public class DemoTest {
    @Test
    public void demo1() throws CloneNotSupportedException {
        User a = new User();
        a.setId("123");
        a.setAge(18);
        a.setName("zhangsan");
        a.setPassword("123456");

        User b = (User) a.clone();
        b.setAge(20);

        System.out.println("=====" + a + "=====");

        System.out.println("=====" + b + "=====");

        System.out.println("a==b?结果:" + (a == b));


    }

}
