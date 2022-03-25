package yun.proxy;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Author: yunCrush
 * Date: 2022/3/25 10:45
 * Description: 通过拦截器来增强逻辑
 */
@Slf4j
public class MyInvocationHandler implements InvocationHandler {
	Object target;
	public MyInvocationHandler(Object target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		log.info("enhance  logical before the method execute");
		// judge method name to ex ecute a specified method
		// 可以方法名做判断，可对指定方法做权限校验等逻辑
		Object ans = method.invoke(target,args);
		log.info("enhance logical after the method  execute");
		return ans;
	}
}
