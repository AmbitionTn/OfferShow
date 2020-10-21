package com.spring.container.main;

import com.spring.container.bean.Cat;
import com.spring.container.bean.Dog;
import org.springframework.beans.factory.Aware;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

import java.util.stream.Stream;

/**
 * @author taoning
 * @create 2020/10/20
 */
public class ListableBeanFactoryApplication {
    public static void main(String[] args) {
        ClassPathResource resource = new ClassPathResource("beanfactory/test1.xml");
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions(resource);

        // 直接打印容器中的所有bean
        System.out.println("加载xml文件后容器中的Bean：");
        Stream.of(beanFactory.getBeanDefinitionNames()).forEach(System.out::println);
        System.out.println();

        beanFactory.registerSingleton("doggg", new Dog());
        System.out.println("手动注册单实例Bean后容器中的所有Bean");
        Stream.of(beanFactory.getBeanDefinitionNames()).forEach(System.out::println);
        System.out.println("容器中真的有注册Dog：" + beanFactory.getBean("doggg"));

        Cat cat = beanFactory.getBean(Cat.class);
        Cat cat1 = beanFactory.getBean(Cat.class);
        System.out.println(cat + " " + cat1);
    }
}
