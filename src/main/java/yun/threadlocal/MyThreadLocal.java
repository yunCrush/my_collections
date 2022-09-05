package yun.threadlocal;

import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Author: yunCrush
 * Date: 2022/3/16 10:20
 * Description: 线程池（多个线程）使用一个simpleDateFormat对象时出现打印相同时间问题
 */
@Slf4j
public class MyThreadLocal {

    public static ExecutorService executorService = Executors.newFixedThreadPool(10);

    // 需要通过synchronized加锁解决
    static MyThreadLocal myThreadLocal = new MyThreadLocal();

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            int finalI = i * 100;
            executorService.submit(() -> {
                // 创建了1000个MyThreadLocal对象，进行优化到值创建一个MyThreadLocal对象
                // String date = new MyThreadLocal().dealTime0(finalI);
                String date = myThreadLocal.dealTime0(finalI);
                System.out.println(date);
            });
        }
        // 关闭线程池
        executorService.shutdown();
    }

    public String dealTime(int second) {
        Date date = new Date(1000 * second);
        // SimpleDateFormat simpleDateFormat = MyFormat.threadLocalDate.get();
        SimpleDateFormat simpleDateFormat = ThreadLocalSafeFormatter.simpleDateFormat;
        return simpleDateFormat.format(date);
    }

    /**
     * 加类锁 来保证只有一个线程进入，但是加锁会影响性能你
     *
     * @param seconds
     * @return
     */
    public String dealTime0(int seconds) {
        Date date = new Date(1000 * seconds);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String s = null;
        // 加锁保证静态成员变量只有个线程进入
        synchronized (MyThreadLocal.class) {
            s = simpleDateFormat.format(date);
        }
        return s;
    }
}

/**
 * threadlocal的正确用法，为每个线程分配一个simpledaterformat副本
 */
class ThreadLocalSafeFormatter {
    // 使用threadlocal創建10个simpledateformat对象
    public static ThreadLocal<SimpleDateFormat> threadLocalDate =
            // 初始化方法1
            // ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-mm-dd HH:mm:ss"));
            new ThreadLocal<SimpleDateFormat>() {
                @Override
                protected SimpleDateFormat initialValue() {
                    // return super.initialValue();
                    return new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
                }
            };
    // 不正确的用法
    static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
}


