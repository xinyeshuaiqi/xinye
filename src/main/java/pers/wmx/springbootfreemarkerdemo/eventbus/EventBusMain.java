package pers.wmx.springbootfreemarkerdemo.eventbus;

import java.util.concurrent.Executors;

import pers.wmx.springbootfreemarkerdemo.eventbus.observer.AObserver;
import pers.wmx.springbootfreemarkerdemo.eventbus.observer.BObserver;
import pers.wmx.springbootfreemarkerdemo.eventbus.observer.CObserver;

/**
 * @author wangmingxin03
 * Created on 2021-12-13
 */
public class EventBusMain {
    private static final EventBus EVENT_BUS =
            new AsyncEventBus(Executors.newFixedThreadPool(10));

    public static void main(String[] args) {
        // 注册三个观察者 扔到本地注册表
        EVENT_BUS.register(new AObserver());
        EVENT_BUS.register(new BObserver());
        EVENT_BUS.register(new CObserver());

        EVENT_BUS.post("haha");
        EVENT_BUS.post(666);
    }

}
