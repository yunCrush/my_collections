package yun.proxy.staticproxy;

import yun.proxy.Child;
import yun.proxy.Person;

/**
 * Author: yunCrush
 * Date:2022-09-03 21:40
 * Description:
 */
public class StaticProxyTest {

    public static void main(String[] args) {
        Person person = new Child();
        PersonProxy proxy = new PersonProxy(person);
        proxy.hello();
    }
}
