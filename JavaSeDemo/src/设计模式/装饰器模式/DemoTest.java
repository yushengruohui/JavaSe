package 设计模式.装饰器模式;

import org.junit.Test;

/**
 * @author: yusheng
 * @create-date: 2019-12-20 09:59
 **/
public class DemoTest {
    @Test
    public void demo1() {
        OldHuman oldHuman = new OldHuman();
        // oldHuman.sleep();
        NewHuman newHuman = new NewHuman(oldHuman);
        newHuman.sleep();
    }

}
