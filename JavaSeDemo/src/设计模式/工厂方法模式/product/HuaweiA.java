package 设计模式.工厂方法模式.product;

/**
 * @author: yusheng
 * @create-date: 2019-12-19 23:34
 **/
public class HuaweiA implements Phone {
    @Override
    public void call() {
        System.out.println("我是华为手机a");
    }
}
