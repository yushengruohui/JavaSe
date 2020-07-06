package 设计模式.简单工厂模式;

/**
 * 具体工厂-手机生产工厂
 *
 * @author: yusheng
 * @create-date: 2019-12-19 22:00
 **/
public class XiaomiFactory {
    /**
     * 根据不同的状态码生产不同的产品
     *
     * @param code
     */
    public static void create(int code) {
        if (code == 1) {
            XiaomiPhone phone = new XiaomiPhoneA();
        } else if (code == 2) {
            XiaomiPhone phone = new XiaomiPhoneB();
        }
    }
}
