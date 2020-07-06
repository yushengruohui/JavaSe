package 设计模式.建造者模式;

/**
 * 建造指导者，规划组件的构建过程，把小组件有序地组成一个大组件或者说复杂对象
 *
 * @author: yusheng
 * @create-date: 2019-12-20 12:23
 **/
public class Director {
    private Builder builder;

    Director(Builder bld) {
        builder = bld;
    }

    public void produceCar() {
        //这里对生产过程进行控制（有序地构建）
        builder.buildFrame();
        builder.buildWidget();
        builder.buildWheel();
        builder.buildEngine();
    }

    public Car getCar() {
        return builder.getCar();
    }
}
