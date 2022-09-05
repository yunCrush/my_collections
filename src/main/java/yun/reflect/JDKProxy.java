package yun.reflect;

/**
 * Author: yunCrush
 * Date:2022/3/24 22:25
 * Description:
 */
public class JDKProxy implements SayHello {
    @Override
    public String sayHello(String name) {
        return "hello" + name;
    }
}
