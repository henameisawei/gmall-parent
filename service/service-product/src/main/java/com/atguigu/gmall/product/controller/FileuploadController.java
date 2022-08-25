package com.atguigu.gmall.product.controller;

import com.atguigu.gmall.common.result.Result;
import com.atguigu.gmall.product.service.FileuploadService;
import com.atguigu.gmall.product.util.MinioProperties;
import io.minio.BucketExistsArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import io.minio.errors.*;
import org.apache.http.util.Args;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

/**
 * @author he
 * @date2022/8/24
 * @apiNote
 */
@RequestMapping("/admin/product")
@RestController
public class FileuploadController {
/*    @Autowired
    MinioProperties minioProperties;*/

    @Autowired
    FileuploadService fileuploadService;

    @PostMapping("fileUpload")
    public Result fileupload(@RequestPart("file") MultipartFile file) throws Exception {


      /*  String url ="";
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
        }*/
        String url = fileuploadService.upload(file);
        return Result.ok(url);

       /* String fileName = System.currentTimeMillis()+ UUID.randomUUID().toString();//文件名
        minioClient.putObject(
                PutObjectArgs.builder().bucket(minioProperties.getBucketName()).object(fileName).stream(
                        file.getInputStream(), file.getSize(), -1)
                        .contentType(file.getContentType())
                        .build());//上传文件
        url = minioProperties.getEndpointUrl()+"/"+minioProperties.getBucketName()+"/"+fileName;

        System.out.println("url:\t"+url);
        //  将文件上传之后的路径返回给页面！
        return Result.ok(url);*/
    }
}
