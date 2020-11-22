package com.owner.ws.instantiation;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * 有参构造函数
 *
 * @project nlz-ws->AutowiredConstructorBean
 * @description WANSI001
 * @create 2020-10-31 22:26
 */
@CacheComponent
public class AutowiredConstructorBean {

    private Dept dept;

    @Autowired
    public AutowiredConstructorBean(Dept dept){
        this.dept = dept;
    }
}
