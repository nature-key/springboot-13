package com.springboot.spring;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.HashMap;
import java.util.Map;

/**
 * exclude = GsonAutoConfiguration.class
 */
@SpringBootApplication(scanBasePackages = "com.springboot",excludeName = "org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration")
public class Application {
    @Value("${server.host:localhost}")
    private  String serverhost;
	public static void main(String[] args) {
        SpringApplication APP = new SpringApplication(Application.class);
//        APP.setBannerMode(Banner.Mode.OFF);
        Map<String,Object> map = new HashMap<>();
        map.put("server.host","127.0.0.1");
        APP.setDefaultProperties(map);
        ConfigurableApplicationContext context = APP.run(args);

        System.out.println(context.getEnvironment().getProperty("server.host"));
        System.out.println(context.getBean(Application.class).serverhost);
        System.out.println(context.getBean(Runnable.class));
//        System.out.println(context.getBean(Gson.class));
        context.close();

	}
}
