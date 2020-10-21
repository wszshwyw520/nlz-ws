package com.owner.ws.instantiation;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 单元测试类
 *
 * @project nlz-ws->SpringUnit
 * @description WANSI001
 * @create 2020-10-21 20:31
 */
public class SpringUnit {

    /**
     * 1.特殊类注册到Spring
     * 2.实现自定义注解 @CacheComponent
     */
    @Test
    public void testDefinitionRegistry(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        User user = (User) applicationContext.getBean("user");
        System.out.println(user);

        //未配置component-scan/bean标签，实现注解容器注册
        Dept dept = (Dept) applicationContext.getBean("dept");
        System.out.println(dept);
    }
}
