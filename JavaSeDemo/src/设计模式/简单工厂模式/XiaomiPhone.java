package 设计模式.简单工厂模式;

/**
 * @author: yusheng
 * @create-date: 2019-12-19 22:04
 **/
public interface XiaomiPhone {
    /**
     * 尺寸
     *
     * @return
     */
    int size();

    /**
     * 颜色
     *
     * @return
     */
    String color();

    /**
     * 打电话
     */
    void call();
}
