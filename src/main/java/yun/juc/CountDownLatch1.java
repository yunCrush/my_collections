package yun.juc;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;

/**
 * Author: yunCrush
 * Date: 2022/3/21 10:02
 * Description: countdonwnlatch使用
 */
public class CountDownLatch1 {
	public static void main(String[] args) {
		CountDownLatch countDownLatch = new CountDownLatch(5);

		for (int i = 0; i < 5; i++) {
			Thread t = new Thread(new MyThread());
			t.start();
		}
		try {
			countDownLatch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("所有任务完成");
	}
}
@Slf4j
class MyThread implements  Runnable{
	@Override
	public void run() {
		try {
			log.info("当前线程正在执行：{}", Thread.currentThread().getName());
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
