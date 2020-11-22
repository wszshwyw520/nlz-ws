package com.owner.ws.instantiation;

import org.springframework.beans.factory.FactoryBean;

/**
 * @project nlz-ws->MyFactoryBean
 * @description WANSI001
 * @create 2020-10-24 11:06
 */
@CacheComponent
public class MyFactoryBean implements FactoryBean<User3> {
    @Override
    public User3 getObject() throws Exception {
        return new User3();
    }

    @Override
    public Class<?> getObjectType() {
        return User3.class;
    }
}
