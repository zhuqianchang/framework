package com.zhuqc.framework;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FrameworkApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(FrameworkApplication.class);
        // 关闭Banner
        application.setBannerMode(Banner.Mode.OFF);
        application.run(args);
    }
}
