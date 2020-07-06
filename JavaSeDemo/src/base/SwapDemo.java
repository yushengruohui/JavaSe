package base;

import org.junit.Test;


/**
 * @Description:
 * @author: yusheng
 * @create-date: 2019-09-30 15:25
 **/
public class SwapDemo {
    @Test
    public void test1() {

        int[] aaaa = new int[3];
        aaaa[0] = 1;
        aaaa[1] = 2;
        //int a = 10;
        //int b = 3;
        //mySwap(a, b);
        //System.out.println("=====" + a + "=====");
        //System.out.println("=====" + b + "=====");
        mySwap2(0, 1, aaaa);
        System.out.println("=====" + aaaa[0] + "=====");


    }

    public void mySwap2(int a, int b, int temp[]) {
        //在Java中，基础数据类型和final修饰的数据类型，进行传参都是值传递，不会改变实参的。
        temp[a] ^= temp[b];
        temp[b] ^= temp[a];
        temp[a] ^= temp[b];
    }

    public void mySwap(int a, int b) {
        a ^= b;
        b ^= a;
        a ^= b;
        System.out.println("=====" + a + "=====");
        System.out.println("=====" + b + "=====");
    }
}
