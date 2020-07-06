package 设计模式.代理模式.动态代理;

/**
 * 委托类，源对象，要被代理的对象
 *
 * @author: yusheng
 * @create-date: 2019-12-20 21:24
 **/
public class Source implements ISource {
    @Override
    public void addUser() {
        System.out.println("我是委托类，我要添加一个用户");
    }
}
