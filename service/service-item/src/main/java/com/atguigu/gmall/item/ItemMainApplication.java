package com.atguigu.gmall.item;

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
public class ItemMainApplication {

    public static void main(String[] args) {
        SpringApplication.run(ItemMainApplication.class,args);
    }
}
