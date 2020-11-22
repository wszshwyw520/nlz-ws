package com.owner.ws.scope;

import com.owner.ws.instantiation.CacheComponent;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.context.request.RequestAttributes;

/**
 * @project nlz-ws->RequestSessionBean
 * @description WANSI001
 * @create 2020-11-22 21:43
 *
 * request作用域
 */
@CacheComponent
@Scope(value = RequestAttributes.REFERENCE_REQUEST)
public class RequestSessionBean {

    /**
     * 1.xml方法该类报错: No Scope registered for scope name 'request'
     * scopes容器中未注册该作用域，因此报错
     *
     * request和session在web环境才会有，特定作用域：webApplicationContext
     *
     * 我们也可以自定义作用域，来管理bean
     */
}
