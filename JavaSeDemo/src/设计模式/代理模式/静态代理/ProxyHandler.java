package 设计模式.代理模式.静态代理;

/**
 * @author: yusheng
 * @create-date: 2019-12-20 21:37
 **/
public class ProxyHandler implements ISource {
    private Source source;

    ProxyHandler() {
        if (source == null) {
            source = new Source();
        }
    }

    @Override
    public int addUser() {
        System.out.println("在被代理对象执行方法前……");
        source.addUser();
        System.out.println("在被代理对象执行方法后……");
        return 0;
    }
}
