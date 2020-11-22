package com.owner.ws;

import com.owner.ws.instantiation.Dept;
import com.owner.ws.instantiation.User;
import com.owner.ws.scope.CustomScopeBean;
import com.owner.ws.scope.ProtoTypeBean;
import com.owner.ws.scope.SessionUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * 单元测试类
 *
 * @project nlz-ws->SpringUnit
 * @description WANSI001
 * @create 2020-10-21 20:31
 */
//@SpringBootTest(classes = SpringUnit.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@RunWith(value = SpringRunner.class)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring.xml"})
public class SpringUnit {

    /**
     * 1.特殊类注册到Spring
     * 2.实现自定义注解 @CacheComponent
     */
    @Test
    public void testDefinitionRegistry(){
        ClassPathXmlApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("spring.xml");

        User user = (User) applicationContext.getBean("user");
        System.out.println(user);

        //未配置component-scan/bean标签，实现注解容器注册
        Dept dept = (Dept) applicationContext.getBean("dept");
        System.out.println(dept);
    }


    /**
     * 多例
     */
    @Test
    public void testScope(){
        ClassPathXmlApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("spring.xml");
        for(int i = 0;i < 10 ; i++){
            new Thread(()->System.out.println(applicationContext.getBean("protoTypeBean"))).start();
        }
    }

    /**
     * 作用域 REQUEST
     */
    @Test
    public void testRequestScope() {
        ClassPathXmlApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("spring.xml");

        applicationContext.getBean("requestSessionBean");
    }



    /**
     * 作用域 CustomScopeBean
     * 线程内实例相同，不同线程实例不同
     */
    @Test
    public void testCustomScopeBeanScope() {
        ClassPathXmlApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("spring.xml");

        for (int i = 0; i < 10 ; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName() + "======" +applicationContext.getBean("customScopeBean"));
                System.out.println(Thread.currentThread().getName() + "======" +applicationContext.getBean("customScopeBean"));
            }).start();
        }
    }

    @Test
    public void testRedisScopeBeanScope() {
        ClassPathXmlApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("spring.xml");

        /**
         * 测试在特定账号下token保持一致，其他均是不同的token
         */
        SessionUtils.IncrAndGetCurUser("zhangsan001");
        System.out.println(applicationContext.getBean("redisInfo"));
        SessionUtils.IncrAndGetCurUser("zhangsan002");
        System.out.println(applicationContext.getBean("redisInfo"));
        SessionUtils.IncrAndGetCurUser("zhangsan003");
        System.out.println(applicationContext.getBean("redisInfo"));
        SessionUtils.IncrAndGetCurUser("zhangsan004");
        System.out.println(applicationContext.getBean("redisInfo"));
        SessionUtils.IncrAndGetCurUser("zhangsan005");
        System.out.println(applicationContext.getBean("redisInfo"));


    }
}
