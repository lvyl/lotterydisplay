package com.lvyl.lotterydisplay;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.lvyl.lotterydisplay.mapper")
public class LotterydisplayApplication {
    public static void main(String[] args) {
        SpringApplication.run(LotterydisplayApplication.class, args);
    }
}
