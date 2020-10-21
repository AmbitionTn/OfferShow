package com.spring.container.main;

import com.spring.container.bean.AwareTestBean;
import com.spring.container.config.AwareConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author taoning
 * @create 2020/10/21
 */
public class AwareApplication {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AwareConfiguration.class);
        AwareTestBean awareTestBean = ctx.getBean(AwareTestBean.class);
        awareTestBean.printBeanNames();

        System.out.println("-----------------");
    }
}
