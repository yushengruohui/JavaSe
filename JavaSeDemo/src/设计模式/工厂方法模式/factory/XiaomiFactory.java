package 设计模式.工厂方法模式.factory;

import 设计模式.工厂方法模式.product.Phone;
import 设计模式.工厂方法模式.product.XiaomiA;

/**
 * @author: yusheng
 * @create-date: 2019-12-19 23:31
 **/
public class XiaomiFactory implements PhoneFactory {
    @Override
    public Phone createPhone() {
        return new XiaomiA();
    }
}
