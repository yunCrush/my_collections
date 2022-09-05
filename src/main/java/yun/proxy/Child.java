package yun.proxy;

import yun.proxy.Person;

/**
 * Author: yunCrush
 * Date:2022-09-03 21:37
 * Description:
 */
public class Child implements Person {
    @Override
    public void hello() {
        System.out.println("i am a child");
    }
}
