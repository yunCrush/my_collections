package yun.proxy.dynamicproxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Author: yunCrush
 * Date:2022-09-03 22:25
 * Description:
 */
public class CglibProxy implements MethodInterceptor {
    private Enhancer enhancer = new Enhancer();
    // 原有的bean
    private Object bean;

    public CglibProxy(Object bean) {
        this.bean = bean;
    }
    public Object getProxy(){
        // 设置需要创建子类的类
        enhancer.setSuperclass(bean.getClass());
        enhancer.setCallback(this);
        // 通过字节码技术动态创建子类实例
        return enhancer.create();
    }
    // 实现MethodInterceptor接口方法
    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("进入Cglib动态代理类");
        // 调用原bean的方法
        return method.invoke(bean,args);
    }
}
