package com.wcyc.upms;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
@EnableDubboConfiguration
@MapperScan("com.wcyc.upms.dao")
public class Application {

    public static void main(String args[]){
        new SpringApplicationBuilder(Application.class)
                .web(false) // 非 Web 应用
                .run(args);
    }
}
