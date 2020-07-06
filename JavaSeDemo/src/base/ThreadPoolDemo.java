package base;

import pojo.MyThreadPool;
import thread.Thread2;

import java.util.concurrent.ExecutorService;


/**
 * @Description:
 * @author: yusheng
 * @create-date: 2019-09-30 15:25
 **/
public class ThreadPoolDemo {
    public static void main(String[] args) {
        // 延迟和周期执行线程的线程池，自定义核心线程数量，任务数量无限，任务定时执行（不是同步），适用于定时执行任务的场景。
        // ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(3);
        ExecutorService executorService = MyThreadPool.getInstance();
        for (int i = 0; i < 10; i++) {

            executorService.execute(new Thread2());
        }
        // for (int i = 0; i < 10; i++) {
        //     // 延迟3s执行
        //     scheduledThreadPool.schedule(new Runnable() {
        //         @Override
        //         public void run() {
        //             for (int j = 0; j < 10; j++) {
        //                 System.out.print(j + "\t");
        //             }
        //             System.out.println();
        //         }
        //     }, 3, TimeUnit.SECONDS);
        //
        // }
        //
        // scheduledThreadPool.shutdown();
        //
        // for (int i = 0; i < 10; i++) {
        //     // 延迟1s后每3秒执行一次，线程池没有结束条件的话会一直执行。
        //     scheduledThreadPool.scheduleAtFixedRate(new Runnable() {
        //         @Override
        //         public void run() {
        //             for (int j = 0; j < 10; j++) {
        //                 System.out.print(j + "\t");
        //             }
        //             System.out.println();
        //         }
        //     }, 1, 3, TimeUnit.SECONDS);
        //
        // }
        // scheduledThreadPool.shutdown();
    }
}
