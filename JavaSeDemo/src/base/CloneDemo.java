package base;

/**
 * @Description:
 * @author: yusheng
 * @create-date: 2019-09-27 16:41
 **/
public class CloneDemo {
    public static void main(String[] args) {
        Integer a = 1;
        Integer b = a;
        b = 3;

        System.out.println("=====" + a + b + "=====");
    }
}
