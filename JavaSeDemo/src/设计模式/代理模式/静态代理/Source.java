package 设计模式.代理模式.静态代理;

/**
 * 源对象，要被代理的对象
 *
 * @author: yusheng
 * @create-date: 2019-12-20 21:24
 **/
public class Source implements ISource {
    @Override
    public int addUser() {
        System.out.println("source添加用户");
        return 1;
    }
}
