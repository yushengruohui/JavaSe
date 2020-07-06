package 设计模式.抽象工厂模式.factory;

import 设计模式.抽象工厂模式.product.HuaweiA;
import 设计模式.抽象工厂模式.product.HuaweiB;
import 设计模式.抽象工厂模式.product.PhoneA;
import 设计模式.抽象工厂模式.product.PhoneB;

/**
 * @author: yusheng
 * @create-date: 2019-12-19 23:31
 **/
public class HuaweiFactory implements PhoneFactory {


    @Override
    public PhoneA createPhoneA() {
        return new HuaweiA();
    }

    @Override
    public PhoneB createPhoneB() {
        return new HuaweiB();
    }
}
