package 设计模式.简单工厂模式;

/**
 * @author: yusheng
 * @create-date: 2019-12-19 22:06
 **/
public class XiaomiPhoneB implements XiaomiPhone {
    @Override
    public int size() {
        return 2;
    }

    @Override
    public String color() {
        return "green";
    }

    @Override
    public void call() {
        System.out.println("小米b");
    }
}
