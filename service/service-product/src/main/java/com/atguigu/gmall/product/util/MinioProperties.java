package com.atguigu.gmall.product.util;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author he
 * @date2022/8/24
 * @apiNote
 */
@Data
@Component
//注意prefix要写到最后一个 "." 符号之前
@ConfigurationProperties(prefix="minio")
public class MinioProperties {
    private String endpointUrl;// endpointUrl: http://192.168.6.101:9000
    private String accessKey;//  accessKey: admin
    private String secreKey;//  secreKey: admin123456
    private String bucketName;//  bucketName: gmall
}
