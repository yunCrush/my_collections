package yun.core;

import java.security.PrivateKey;
import java.util.PriorityQueue;

/**
 * Author: yunCrush
 * Date:2022-09-02 15:12
 * Description:
 */
public class SimpleClass {

    static class MyInnerClass {
        public void m1() {
            System.out.println("hello m1");
        }
    }

    public static void main(String[] args) {
        Person p = new child();
        p.hello();
    }
}

abstract class Person {
    // 修饰只可public or protected
    public abstract void hello();

    public void hello2() {
        System.out.println("hello world2");
    }
}

interface Animal {
    // 变量隐式： public static final
    String name = "";
    // 方法隐式：public abstract
    void m2();
}

// 不用内部类实现抽象类与接口
class child extends Person {
    @Override
    public void hello() {
        System.out.println("hello world");
    }
}
// System.gc() 手动gc -Xms10m -Xmx10m
