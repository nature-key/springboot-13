package com.springboot.bean;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootConfiguration
public class BeanConfig {
    @Bean
    public Runnable createRunable(){
        return ()->{};
    }


}
