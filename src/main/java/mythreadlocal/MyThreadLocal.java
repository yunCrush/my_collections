package mythreadlocal;

import lombok.extern.slf4j.Slf4j;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Author: yunCrush
 * Date: 2022/3/16 10:20
 * Description:
 */
@Slf4j
public class MyThreadLocal {
	public static ExecutorService threadLocal = Executors.newFixedThreadPool(10);
	public static void main(String[] args) {
		threadLocal.submit(new Runnable() {
			public void run() {
				for (int i = 1; i < 1000; i++) {
					 int finalI = i;
					 log.info(new MyThreadLocal().dealTime(i));
					 log.debug("debug");
				}
			}
		});
	}
	public String dealTime(int second){
		Date date = new Date(1000 * second);
		// SimpleDateFormat simpleDateFormat = MyFormat.threadLocalDate.get();
		SimpleDateFormat simpleDateFormat = MyFormat.simpleDateFormat;
		return simpleDateFormat.format(date);
	}

}
class MyFormat{
	// 使用threadlocal創建10个simpledateformat对象
	public static ThreadLocal<SimpleDateFormat> threadLocalDate =
			ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-mm-dd HH:mm:ss"));
	public static SimpleDateFormat  simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");

}


