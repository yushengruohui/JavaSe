package 设计模式.建造者模式;

/**
 * 具体构建过程（具体套餐，可以有多个）
 *
 * @author: yusheng
 * @create-date: 2019-12-20 11:57
 **/
public class ConcreteBuilder2 implements Builder {
    Car myCar = new MyCar();

    @Override
    public Car getCar() {
        // 返回当前的具体产品（复杂对象）
        return myCar;
    }

    @Override
    public void buildWheel() {
        myCar.setWheel("自定义轮胎2");
    }

    @Override
    public void buildFrame() {
        myCar.setFrame("自定义窗2");
    }

    @Override
    public void buildEngine() {
        myCar.setEngine("自定义引擎2");
    }

    @Override
    public void buildWidget() {
        myCar.setWidget("自定义部件2");
    }

}
