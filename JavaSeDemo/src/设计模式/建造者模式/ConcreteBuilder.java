package 设计模式.建造者模式;

/**
 * 具体构建过程（具体套餐，可以有多个）
 *
 * @author: yusheng
 * @create-date: 2019-12-20 11:57
 **/
public class ConcreteBuilder implements Builder {
    // 具体要生成的复杂对象
    Car myCar = new MyCar();

    @Override
    public Car getCar() {
        // 返回当前的具体产品（复杂对象）
        return myCar;
    }

    // 设置属性
    @Override
    public void buildWheel() {
        myCar.setWheel("自定义轮胎1");
    }

    @Override
    public void buildFrame() {
        myCar.setFrame("自定义窗1");
    }

    @Override
    public void buildEngine() {
        myCar.setEngine("自定义引擎1");
    }

    @Override
    public void buildWidget() {
        myCar.setWidget("自定义部件1");
    }

}
