package 设计模式.建造者模式;

/**
 * 汽车所有组件配置
 *
 * @author: yusheng
 * @create-date: 2019-12-20 11:49
 **/
public interface Car {
    void setWheel(String wheel);

    void setFrame(String frame);

    void setEngine(String engine);

    void setWidget(String widget);
}
