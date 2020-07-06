package pojo;

import java.util.concurrent.*;

/**
 * @author: yusheng
 * @create-time 2019-11-09 15:22
 **/

public class MyThreadPool {

    //参数初始化
    private static final int CPU_COUNT = Runtime.getRuntime().availableProcessors();
    //核心线程数量大小
    private static final int corePoolSize = Math.max(2, Math.min(CPU_COUNT - 1, 4));
    //线程池最大容纳线程数，任务为cpu密集类型的计算机场景。
    private static final int maximumPoolSize = CPU_COUNT * 2 + 1;
    //线程池最大容纳线程数，任务为I/O密集类型的计算机场景。
    // private static final int maximumPoolSize = CPU_COUNT + 1;
    //线程空闲后的存活时长
    private static final int keepAliveTime = 30;
    // 任务队列，有三种通用提交请求（任务）策略
    private static final BlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(maximumPoolSize);
    // 拒绝策略 ，有四种通用拒绝请求（任务）策略
    private static final RejectedExecutionHandler policy = new ThreadPoolExecutor.DiscardPolicy();
    // 线程池对象
    private volatile static ThreadPoolExecutor executor;

    private MyThreadPool() {
    }

    // 获取单例的线程池对象
    public static ThreadPoolExecutor getInstance() {
        if (executor == null) {
            synchronized (MyThreadPool.class) {
                if (executor == null) {
                    executor = new ThreadPoolExecutor(corePoolSize,// 核心线程数
                            maximumPoolSize, // 最大线程数
                            keepAliveTime, // 闲置线程存活时间
                            TimeUnit.SECONDS,// keepAliveTime的时间单位
                            queue,// 线程队列
                            policy// 线程工厂
                    );
                }
            }
        }
        return executor;
    }

    public void execute(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        executor.execute(runnable);
    }

    // 从线程队列中移除对象
    public void cancel(Runnable runnable) {
        if (executor != null) {
            executor.getQueue().remove(runnable);
        }
    }

}