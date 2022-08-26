package com.atguigu.gmall.web;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author he
 * @date2022/8/26
 * @apiNote
 */
@EnableFeignClients
@SpringCloudApplication
public class WebAllAppplication {
    public static void main(String[] args) {
        SpringApplication.run(WebAllAppplication.class,args);
    }
}
