package yun.proxy.staticproxy;

import yun.proxy.Animal;

/**
 * Author: yunCrush
 * Date:2022-09-03 21:58
 * Description: 代理Animal接口
 */
public class AnimalProxy implements Animal {
    private  Animal animal;

    public AnimalProxy(Animal animal){
        this.animal = animal;
    }
    @Override
    public void wake() {
        animal.wake();
    }
}
