package com.owner.ws.instantiation;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.ConstructorArgumentValues;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.stereotype.Component;

/**
 * @project nlz-ws->BeanDefinitionTest
 * @description WANSI001
 * @create 2020-10-21 20:15
 */
public class BeanDefinitionTest implements BeanDefinitionRegistryPostProcessor {

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry beanDefinitionRegistry) throws BeansException {

        //1.实现特殊bean的注册
        //在此处将类注册到Spring容器中
        GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
        beanDefinition.setBeanClass(User.class);
        MutablePropertyValues propertyValues = beanDefinition.getPropertyValues();

        //设置类属性值
        propertyValues.addPropertyValue("userNo","CM-PA-01982773");
        propertyValues.addPropertyValue("userNo","白小纯");
        propertyValues.addPropertyValue("deptNo","001");
        propertyValues.addPropertyValue("deptName","奎皇朝根据地");
        propertyValues.addPropertyValue("imageAddr","主宰神像");

        //注册到beanFactory容器中
        beanDefinitionRegistry.registerBeanDefinition("user",beanDefinition);

        //2.自定义注解支撑
        ClassPathBeanDefinitionScanner scanner = new ClassPathBeanDefinitionScanner(beanDefinitionRegistry);
        scanner.addIncludeFilter(new AnnotationTypeFilter(CacheComponent.class));
//        scanner.addIncludeFilter(new AnnotationTypeFilter(Component.class));
        scanner.scan("com.owner.ws");
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        String[] beanDefinitionNames = configurableListableBeanFactory.getBeanDefinitionNames();
        for (int i = 0; i < beanDefinitionNames.length; i++) {
            String beanDefinitionName = beanDefinitionNames[i];
            //遍历容器所有的beanDefinition
            BeanDefinition beanDefinition = configurableListableBeanFactory.getBeanDefinition(beanDefinitionName);
            System.out.println(beanDefinition.getBeanClassName());
        }
    }
}
