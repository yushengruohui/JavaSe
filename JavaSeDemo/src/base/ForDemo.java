package base;

import org.junit.Test;

/**
 * @author yusheng
 * Created on 2020-06-29 21:20
 **/
public class ForDemo {
    @Test
    public void demo() {
        for (int i = 0; true; i++) {
            // 无限循环执行
            System.out.println("111");
            if(i==100){
                break;
            }
        }
    }
}
