package com.owner.ws.scope;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

/**
 * @project nlz-ws->CustomScope
 * @description WANSI001
 * @create 2020-11-22 22:01
 *
 * 自定义作用域:
 * 示例：作用范围在线程内，同一个线程，打印的实例是同一个，不同线程打印的不同
 */
public class CustomScope implements Scope {

    public static final String IND_SCOPE = "customScope";

    private ThreadLocal threadLocal = new ThreadLocal();

    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {
        if(threadLocal.get() != null){
            return threadLocal.get();
        }else {
            Object object = objectFactory.getObject();
            threadLocal.set(object);
            return object;
        }
    }

    @Override
    public Object remove(String name) {
        return null;
    }

    @Override
    public void registerDestructionCallback(String name, Runnable callback) {

    }

    @Override
    public Object resolveContextualObject(String key) {
        return null;
    }

    @Override
    public String getConversationId() {
        return null;
    }
}
