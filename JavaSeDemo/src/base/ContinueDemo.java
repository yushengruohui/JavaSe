package base;

/**
 * @Description:
 * @author: yusheng
 * @create-date: 2019-09-27 17:09
 **/
public class ContinueDemo {
    public static void main(String[] args) {
        for (int j = 0; j < 2; j++) {
            for (int i = 0; i < 10; i++) {
                if (i == 3) {
                    break;
                }
                System.out.println("=====" + i + "=====");
            }
        }
        for (int j = 0; j < 2; j++) {
            for (int i = 0; i < 10; i++) {
                if (i == 3) {
                    continue;
                }
                System.out.println("=====" + i + "=====");
            }
        }
        ok:
        for (int j = 0; j < 2; j++) {
            for (int i = 0; i < 10; i++) {
                if (i == 3) {
                    continue ok;
                }
                System.out.println("=====" + i + "=====");
            }
        }
    }
}
