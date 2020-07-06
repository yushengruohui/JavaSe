package 设计模式.工厂方法模式.factory;

import 设计模式.工厂方法模式.product.HuaweiA;
import 设计模式.工厂方法模式.product.Phone;

/**
 * @author: yusheng
 * @create-date: 2019-12-19 23:31
 **/
public class HuaweiFactory implements PhoneFactory {
    @Override
    public Phone createPhone() {
        return new HuaweiA();
    }
}
