package 设计模式.外观模式;

import org.junit.Test;

/**
 * @author: yusheng
 * @create-date: 2019-12-20 09:59
 **/
public class DemoTest {
    @Test
    public void demo1() throws CloneNotSupportedException {
        User user = new User();
        user.createCar();
    }

}
