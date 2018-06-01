package com.wcyc.upms.web;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication(scanBasePackages = {"com.wcyc.upms","com.wcyc.base","com.wcyc.log"})
@EnableDubboConfiguration
public class Application {

    public static void main(String args[]){
        new SpringApplicationBuilder(Application.class).run(args);
    }
}
