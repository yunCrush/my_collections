package yun.proxy.dynamicproxy;

import yun.proxy.Child;

/**
 * Author: yunCrush
 * Date:2022-09-03 22:35
 * Description: cglib动态代理测试类
 */
public class CglibProxyTest {
    public static void main(String[] args) {
        CglibProxy proxy = new CglibProxy(new Child());
        Child child = (Child) proxy.getProxy();
        child.hello();
    }
}
