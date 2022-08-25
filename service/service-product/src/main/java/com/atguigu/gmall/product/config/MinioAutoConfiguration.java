package com.atguigu.gmall.product.config;

import com.atguigu.gmall.product.util.MinioProperties;
import io.minio.BucketExistsArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import org.checkerframework.checker.units.qual.min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author he
 * @date2022/8/25
 * @apiNote
 */
@Configuration
public class MinioAutoConfiguration {

    @Autowired
    MinioProperties minioProperties;


    @Bean
    public MinioClient minioClient() throws  Exception{
        MinioClient minioClient =
                MinioClient.builder()
                        .endpoint(minioProperties.getEndpointUrl())
                        .credentials(minioProperties.getAccessKey(), minioProperties.getSecreKey())
                        .build();
        boolean exists = minioClient.bucketExists(BucketExistsArgs.builder().bucket(minioProperties.getBucketName()).build());
        if (exists){
            System.out.println(minioProperties.getBucketName()+"已存在");
        }else {
            minioClient.makeBucket(MakeBucketArgs.builder().bucket(minioProperties.getBucketName()).build());//创建捅
        }
        return minioClient;
    }
}
