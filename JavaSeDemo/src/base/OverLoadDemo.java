package base;

import org.junit.Test;

/**
 * @author: yusheng
 * @create-time 2019-11-02 09:39
 **/
public class OverLoadDemo {
    @Test
    public void test1() {
        int a = 1, b = 2;
        max(a, b);//编译器不知道调用那个函数
        // int c = max(a, b);// 编译器不知道调用那个函数
        float d = max(a, b); // 编译器不知道调用那个函数
    }

    public float max(int a, int b) {
        return Float.valueOf(a + b);
    }

    // public int max(int a, int b) {
    //     return a + b;
    // }

}
