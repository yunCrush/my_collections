package yun.threadlocal;

/**
 * Author: yunCrush
 * Date:2022-09-02 11:42
 * Description:
 */
public class ThreadLocalNPE {

    public ThreadLocal<Long> context = new ThreadLocal<>();
    public void set() {
        context.set(Thread.currentThread().getId());
    }

    // 因为返回的是泛型，转long时调用的longValue()，正确应该Long
    public long get() {

        return context.get();

    }

    public static void main(String[] args) {
        ThreadLocalNPE npe = new ThreadLocalNPE();

        // 没有初始化赋值，return null
        npe.get();
        // Thread
    }
}

