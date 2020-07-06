package thread;

/**
 * @author: yusheng
 * @create-time 2019-11-10 01:01
 **/
public class Thread1 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.print(i + "\t");
        }
    }
}
