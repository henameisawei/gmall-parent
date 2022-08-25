package com.atguigu.gmall.activity;

import com.atguigu.gmall.common.config.Swagger2Config;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.context.annotation.Import;

/**
 * @author he
 * @date2022/8/25
 * @apiNote
 */
@Import({Swagger2Config.class})
@MapperScan("com.atguigu.gmall.activity.mapper")
@SpringCloudApplication
public class ActivityMainApplication {
    public static void main(String[] args) {
        SpringApplication.run(ActivityMainApplication.class,args);
    }
}
