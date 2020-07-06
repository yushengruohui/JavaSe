package base;

import org.junit.Test;


/**
 * @Description:
 * @author: yusheng
 * @create-date: 2019-09-30 15:25
 **/
public class ThreadDemo {
    public static class Thread1 extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.print(i + "\t");
            }
        }
    }

    public static class Thread2 implements Runnable {
        @Override
        public void run() {
            System.out.println("线程");
            for (int i = 0; i < 10; i++) {
                System.out.print(i + "\t");
            }
        }
    }

    @Test
    public void test() {
        int i;
        try {
            i = 0;
        } catch (Exception e) {
            System.out.println("===== 捕捉到异常 =====");

        } finally {
            System.out.println("===== 最终输出 =====");
        }
    }

    @Test
    public void test1() {
        Thread1 myThread = new Thread1();
        myThread.run();
    }

    @Test
    public void test2() {
        Thread myThread = new Thread(new Thread2());
        myThread.run();
    }
}
