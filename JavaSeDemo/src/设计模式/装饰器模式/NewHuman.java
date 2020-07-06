package 设计模式.装饰器模式;

/**
 * 装饰过程
 *
 * @author: yusheng
 * @create-date: 2019-12-20 13:04
 **/
public class NewHuman implements Human {
    private OldHuman oldHuman;

    NewHuman(OldHuman oldHuman) {
        this.oldHuman = oldHuman;
    }

    @Override
    public void sleep() {
        System.out.println("检查是否关门");
        oldHuman.sleep();
        System.out.println("睡醒了，检查一下钱还在不");
    }
}
