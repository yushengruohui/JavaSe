package 设计模式.抽象工厂模式.factory;

import 设计模式.抽象工厂模式.product.PhoneA;
import 设计模式.抽象工厂模式.product.PhoneB;

/**
 * @author: yusheng
 * @create-date: 2019-12-19 23:30
 **/
public interface PhoneFactory {

    PhoneA createPhoneA();

    PhoneB createPhoneB();
}
