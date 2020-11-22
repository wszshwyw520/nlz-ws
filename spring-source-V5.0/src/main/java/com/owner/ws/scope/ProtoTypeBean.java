package com.owner.ws.scope;

import com.owner.ws.instantiation.CacheComponent;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;

/**
 * @project nlz-ws->ProtoTypeBean
 * @description WANSI001
 * @create 2020-11-22 19:04
 */
@CacheComponent
//@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ProtoTypeBean {

    /**
     * 多例循环依赖会报错 throw new BeanCurrentlyInCreationException(beanName);
     */
}
