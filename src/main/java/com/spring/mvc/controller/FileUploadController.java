package com.spring.mvc.controller;


import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * 文件上传组件
 * Created by ASUS on 2017/4/21.
 */
@Controller
@RequestMapping("/file")
public class FileUploadController {

    private static Logger log = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping(value = "/uploadInit",method = RequestMethod.GET)
    public String fileUpload() {

        return "/upload/fileUpload";
    }

    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public String fileUpload(@RequestParam("file") MultipartFile file) throws IOException {

        if(!file.isEmpty()){
            log.debug("file is name:{]", file.getOriginalFilename());
            FileUtils.copyInputStreamToFile(file.getInputStream(), new File("D:/", System.currentTimeMillis() + file.getOriginalFilename()));
        }

        return "hello";
    }


}
