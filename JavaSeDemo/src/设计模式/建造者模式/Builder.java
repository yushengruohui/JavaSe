package 设计模式.建造者模式;

/**
 * 建造者，构造器，生成器，抽象构建过程（套餐）
 *
 * @author: yusheng
 * @create-date: 2019-12-20 11:55
 **/
public interface Builder {
    void buildWheel();

    void buildFrame();

    void buildEngine();

    void buildWidget();

    Car getCar();
}
