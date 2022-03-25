package yun.proxy;

import java.lang.reflect.Proxy;
import java.util.logging.Handler;

/**
 * Author: yunCrush
 * Date: 2022/3/25 10:51
 * Description:
 */
public class JDKProxyTest {
	public static void main(String[] args) {
		//获取需要加强的对象的handler
		MyInvocationHandler handler = new MyInvocationHandler(new HelloImpl());
		// 获取接口对象
		Hello hello = (Hello) Proxy.newProxyInstance(Hello.class.getClassLoader(),
				new Class[] {Hello.class},handler);
		hello.sayHello("yuncrush");
	}

}
