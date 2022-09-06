package yun.threadlocal;

/**
 * Author: yunCrush
 * Date:2022-09-02 10:28
 * Description: 展示Threadlocal的用法2：将拦截器中的用户信息放入，不需要层层传递
 * 解决userMap的多线程问题
 * 可以在方法间，也可以在class间，同一个线程即可
 */
public class MyThreadLocal2  {
    public static ThreadLocal<UserInfo> userInfoContext = new ThreadLocal<>();

    public static void main(String[] args) {
        // Thread
        MyThreadLocal2 myThreadLocal2 = new MyThreadLocal2();
        myThreadLocal2.m1();
        myThreadLocal2.m2();
    }

    public void m1() {
        UserInfo userInfo = new UserInfo("yyyyC", 22);
        // 使用set方法进行初始化，不再使用InitValue();
        MyThreadLocal2.userInfoContext.set(userInfo);
    }

    // 可以直接获取到当前线程关于用户的信息
    public void m2() {
        System.out.println("method2: ");
        System.out.println(MyThreadLocal2.userInfoContext.get().toString());
    }
}
