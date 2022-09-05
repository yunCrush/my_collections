package yun;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;

/**
 * Author: yunCrush
 * Date:2022-09-02 16:36
 * Description: 演示强软弱虚4种应用
 * 前置知识：设置jvm内存大小 -Xms10m -Xmx10m
 * 手动开启GC： System.gc()
 */
public class ReferenceDemo {

    @Override
    protected void finalize() throws Throwable {
        System.out.println("finaliz() invoked");
    }

    public static void main(String[] args) {
        // strongReferenceSample();
        // softReferenceSample();
        // weakReferenceSample();
        phatomReferenceSample();

    }

    /**
     * 强引用：不管是否GC都不会回收
     */
    public static void strongReferenceSample() {
        ReferenceDemo demo = new ReferenceDemo();
        System.out.println("gc前： " + demo);
        // 没有引用指向demo会被gc
        demo = null;
        System.gc();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("gc后：" + demo);
    }

    /**
     * 软引用：内存不足GC时，回收
     * 内存够用的情况，即时发生GC也不会回收对象
     * 手动设置内存大小 -Xms10m -Xmx10m
     */
    public static void softReferenceSample() {
        SoftReference<ReferenceDemo> demo = new SoftReference<>(new ReferenceDemo());
        System.out.println("内存够用，gc前： " + demo.get());
        System.gc();
        System.out.println("内存够用, gc后：" + demo.get());
        try {
            // 创建9M的对象，内存不足，demo软引用会被回收
            byte[] bytes = new byte[9 * 1024 * 1024];
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("内存不够用gc后：" + demo.get());
        }
    }

    /**
     * 弱引用：发生GC就会被回收
     */
    public static void weakReferenceSample() {
        WeakReference<ReferenceDemo> demo = new WeakReference<>(new ReferenceDemo());
        System.out.println("内存够用，gc前： " + demo.get());
        System.gc();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("内存够用, gc后：" + demo.get());
    }

    /**
     * 虚引用，与引用队列搭配使用，ReferenceQueue,在被回收前放入引用队列
     */
    public static void phatomReferenceSample() {
        ReferenceQueue<ReferenceDemo> queue = new ReferenceQueue<>();
        PhantomReference<ReferenceDemo> demo = new PhantomReference<>(new ReferenceDemo(), queue);
        System.out.println("对象: " + demo.get());
    }
}
