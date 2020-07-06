package 设计模式.工厂方法模式;

import org.junit.Test;
import 设计模式.工厂方法模式.factory.PhoneFactory;
import 设计模式.工厂方法模式.factory.XiaomiFactory;
import 设计模式.工厂方法模式.product.Phone;

/**
 * @author: yusheng
 * @create-date: 2019-12-20 09:59
 **/
public class DemoTest {
    @Test
    public void demo1() {
        PhoneFactory factory = new XiaomiFactory();
        Phone phone = factory.createPhone();
        phone.call();
    }

}
