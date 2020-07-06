package 设计模式.抽象工厂模式;

import org.junit.Test;
import 设计模式.抽象工厂模式.factory.PhoneFactory;
import 设计模式.抽象工厂模式.factory.XiaomiFactory;
import 设计模式.抽象工厂模式.product.PhoneA;
import 设计模式.抽象工厂模式.product.PhoneB;

/**
 * @author: yusheng
 * @create-date: 2019-12-20 09:59
 **/
public class DemoTest {
    @Test
    public void demo1() {
        PhoneFactory factory = new XiaomiFactory();
        PhoneA xiaomiA = factory.createPhoneA();
        PhoneB xiaomiB = factory.createPhoneB();
        xiaomiA.call();
        xiaomiB.call();
    }

}
