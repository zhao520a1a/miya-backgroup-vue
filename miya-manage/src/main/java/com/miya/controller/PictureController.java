package com.miya.controller;

import com.miya.common.utils.FastDFSClient;
import com.miya.common.utils.StringUtil;
import com.miya.dto.ResponseModal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * 图片上传controller
 * @author 赵金鑫
 * @date 2017年11月07日
 */
@Slf4j
@RestController
@RequestMapping("/pic")
public class PictureController {

    //@Value("${IMAGE_SERVER_URL}")
    private String IMAGE_SERVER_URL;

    @RequestMapping("/upload")
    public ResponseModal picUpload(@RequestParam String id, @RequestBody MultipartFile uploadFile) {
       log.info("id:{} file:{}",id,uploadFile);
       try {
           //接收上传文件 + 取扩展名
           String originalFilename = uploadFile.getOriginalFilename();
           String extName = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);

           //上传到服务器上
           FastDFSClient fastDFSClient = new FastDFSClient("classpath:resource/fdfs_client;.conf");
           String url = fastDFSClient.uploadFile(uploadFile.getBytes(), extName);
           url = IMAGE_SERVER_URL + url;
           return  ResponseModal.builder().code(ResponseModal.RespCode.OK).data(url).msg("图片上传成功").build();
       } catch (Exception e) {
           log.info("{}", StringUtil.getTrace(e));
           return  ResponseModal.builder().code(ResponseModal.RespCode.OK).data("").msg("图片上传失败").build();
       }
    }




}
