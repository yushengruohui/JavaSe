package 设计模式.抽象工厂模式.factory;

import 设计模式.抽象工厂模式.product.PhoneA;
import 设计模式.抽象工厂模式.product.PhoneB;
import 设计模式.抽象工厂模式.product.XiaomiA;
import 设计模式.抽象工厂模式.product.XiaomiB;

/**
 * @author: yusheng
 * @create-date: 2019-12-19 23:31
 **/
public class XiaomiFactory implements PhoneFactory {

    @Override
    public PhoneA createPhoneA() {
        return new XiaomiA();
    }

    @Override
    public PhoneB createPhoneB() {
        return new XiaomiB();
    }
}
