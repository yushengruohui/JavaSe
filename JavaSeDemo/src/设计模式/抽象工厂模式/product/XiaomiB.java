package 设计模式.抽象工厂模式.product;

/**
 * @author: yusheng
 * @create-date: 2019-12-19 23:34
 **/
public class XiaomiB implements PhoneB {
    @Override
    public void call() {
        System.out.println("我是小米手机b");
    }
}
