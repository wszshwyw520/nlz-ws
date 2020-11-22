package com.owner.ws.scope;

import com.owner.ws.instantiation.CacheComponent;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * @project nlz-ws->RegistryScopePostProcessor
 * @description WANSI001
 * @create 2020-11-22 22:00
 */
@CacheComponent
public class RegistryScopePostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        beanFactory.registerScope(CustomScope.IND_SCOPE,new CustomScope());
        beanFactory.registerScope(RedisScope.REDIS_SCOPE,new RedisScope());
    }
}
