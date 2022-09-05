package yun.proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Author: yunCrush
 * Date:2022-09-03 21:50
 * Description: 一个代理类即可代理所有接口
 *
 */
public class JdkProxy implements InvocationHandler {
    // 这里传入原有的bean是因为后续调用原有的bean的方法
    private Object bean;

    public JdkProxy(Object bean) {
        this.bean = bean;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 逻辑判断
        System.out.println("进入jdk动态代理类");

        // 调用原有的bean的方法
        return method.invoke(bean, args);
    }
}
