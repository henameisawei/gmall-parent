package com.atguigu.gmall.product.service.impl;

import com.atguigu.gmall.product.service.FileuploadService;
import com.atguigu.gmall.product.util.MinioProperties;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

/**
 * @author he
 * @date2022/8/25
 * @apiNote
 */
@Service
public class FileuploadServiceImpl implements FileuploadService {
    @Autowired
    MinioClient minioClient;
    @Autowired
    MinioProperties minioProperties;
    @Override
    public String upload(MultipartFile file) throws Exception {
        String url = "";

        String fileName = System.currentTimeMillis()+ UUID.randomUUID().toString();//文件名
        minioClient.putObject(
                PutObjectArgs.builder().bucket(minioProperties.getBucketName()).object(fileName).stream(
                        file.getInputStream(), file.getSize(), -1)
                        .contentType(file.getContentType())
                        .build());//上传文件
        url = minioProperties.getEndpointUrl()+"/"+minioProperties.getBucketName()+"/"+fileName;

        System.out.println("url:\t"+url);
        return url;
    }
}
