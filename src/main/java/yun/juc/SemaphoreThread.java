package yun.juc;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 * Author: yunCrush
 * Date:2022/3/22 10:06
 * Description: semaphore简单使用
 */
@Slf4j
public class SemaphoreThread extends Thread {

    private final Semaphore semaphore;
    private final Random random = new Random();

    public SemaphoreThread(String name, Semaphore semaphore) {
        super(name);
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();
            log.info("{}  get a semaphore", Thread.currentThread().getName());
            Thread.sleep(random.nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        semaphore.release();
        log.info("{}  release a semaphore", Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(2);
        for (int i = 0; i < 5; i++) {
            new SemaphoreThread(i + " classmate", semaphore).start();
        }
    }
}
