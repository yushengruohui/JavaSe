package base;

import org.junit.Test;

/**
 * @author: yusheng
 * @create-time 2019-10-28 10:30
 **/
public class WhileDemo {

    @Test
    public void test1() {
        //int i = 10;

        //while (i == 0) {
        //    i++;
        //}
        String string = "123456";
        char iEnd = 0;
        System.out.println("iEnd = " + iEnd);
        String substring = string.substring(1, iEnd);


        System.out.println("string.substring(1, '3') = " + substring);

        //do {
        //    i++;
        //} while (i == 0);
        //System.out.println("i = " + i);

    }

}
