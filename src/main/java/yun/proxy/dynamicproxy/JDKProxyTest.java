package yun.proxy.dynamicproxy;

import yun.proxy.Animal;
import yun.proxy.Person;
import yun.proxy.Child;
import yun.proxy.Elephant;

import java.lang.reflect.Proxy;

/**
 * Author: yunCrush
 * Date:2022-09-03 22:01
 * Description:
 * jdkproxy 只可基于接口进行代理，并且生成的代理类也只可赋值给接口
 *
 */
public class JDKProxyTest {
    public static void main(String[] args) {
        JdkProxy proxy = new JdkProxy(new Child());
        Person child = (Person) Proxy.newProxyInstance(proxy.getClass().getClassLoader(),new Class[]{Person.class},proxy);
        child.hello();

        JdkProxy proxy1 = new JdkProxy(new Elephant());
        Animal elephant = (Animal)Proxy.newProxyInstance(proxy1.getClass().getClassLoader(),new Class[]{Animal.class},proxy1);
        elephant.wake();



    }
}
