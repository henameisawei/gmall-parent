package com.atguigu.gmall.product.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author he
 * @date2022/8/25
 * @apiNote
 */
public interface FileuploadService {
    String upload(MultipartFile file) throws IOException, Exception;
}
