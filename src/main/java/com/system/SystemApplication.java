package com.system;

import com.system.util.MyMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class, scanBasePackages="com.system")

public class SystemApplication {


    public static void main(String[] args) {
        SpringApplication.run(SystemApplication.class, args);
    }


}

