package 设计模式.简单工厂模式;

/**
 * @author: yusheng
 * @create-date: 2019-12-19 22:06
 **/
public class XiaomiPhoneA implements XiaomiPhone {
    @Override
    public int size() {
        return 1;
    }

    @Override
    public String color() {
        return "red";
    }

    @Override
    public void call() {
        System.out.println("小米a");
    }
}
