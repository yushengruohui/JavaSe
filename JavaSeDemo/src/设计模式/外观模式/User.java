package 设计模式.外观模式;

/**
 * 这个就是外观类
 *
 * @author: yusheng
 * @create-date: 2019-12-21 12:53
 **/
public class User {
    public void createCar() {
        System.out.println("不管你们那么多，调用我就可以直接生成一辆车了");
        System.out.println("===========");
        UserC userC = new UserC();
        UserB userB = new UserB();
        UserA userA = new UserA();
        userC.create();
        userB.create();
        userA.create();
    }
}
