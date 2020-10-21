package com.spring.container.config;

import com.spring.container.bean.AwareTestBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author taoning
 * @create 2020/10/21
 */
@Configuration
public class AwareConfiguration {

    @Bean
    public AwareTestBean awareTestBean() {
        return new AwareTestBean();
    }
}
