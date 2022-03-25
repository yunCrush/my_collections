package yun.proxy;

import com.sun.media.jfxmedia.logging.Logger;
import lombok.extern.slf4j.Slf4j;

/**
 * Author: yunCrush
 * Date: 2022/3/25 10:43
 * Description:
 */
@Slf4j
public class HelloImpl  implements  Hello{
	@Override
	public void sayHello(String name) {
		log.info("hello world: " + name);
	}
}
