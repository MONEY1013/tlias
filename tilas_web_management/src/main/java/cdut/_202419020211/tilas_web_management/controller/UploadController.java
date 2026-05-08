package cdut._202419020211.tilas_web_management.controller;

import cdut._202419020211.tilas_web_management.pojo.Result;
import cdut._202419020211.tilas_web_management.utils.AliyunOSSOperator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@Slf4j
@RestController
public class UploadController {
    @Autowired
    private AliyunOSSOperator ossOperator;

    @PostMapping("/upload")
    public Result upload(@RequestParam("file") MultipartFile file) throws Exception {
        log.info("上传文件：{}",file);
        if (!file.isEmpty()) {
            String fileName = file.getOriginalFilename();
            String suffixName = fileName.substring(fileName.lastIndexOf("."));
            String uniqueName = UUID.randomUUID().toString() + suffixName;

            String url = ossOperator.upload(file.getBytes(), uniqueName);
            return Result.success(url);
        }
        return Result.error("上传文件失败");
    }
}
