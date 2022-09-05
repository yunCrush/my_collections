package yun.proxy.staticproxy;

import yun.proxy.Person;

/**
 * Author: yunCrush
 * Date:2022-09-03 21:35
 * Description: 代理Person接口，一个接口需要一个代理类
 */
public class PersonProxy implements Person {

    Person person;

    public PersonProxy(Person person) {
        this.person = person;
    }

    /**
     * 根据传入的子类，去调用对应的子类的方法
     */
    @Override
    public void hello() {
        person.hello();
    }
}
