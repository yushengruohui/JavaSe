package arithmetic;

import org.junit.Test;

/**
 * @Description:
 * @author: yusheng
 * @create-date: 2019-10-13 16:33
 **/
public class IfTest {
    @Test
    public void test() {
        int i = 0;
        recursive(i);
    }

    public void recursive(int i) {
        if (i < 100) {
            i++;
            System.out.println(i);
            recursive(i);
        }
    }
}
