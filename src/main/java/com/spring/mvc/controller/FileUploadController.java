package com.spring.mvc.controller;


import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;

/**
 * 文件上传组件
 * Created by ASUS on 2017/4/21.
 */
@Controller
@RequestMapping("/file")
public class FileUploadController {
    //可以使用这个方法写日志 可以不用@Slf4j方法写日志
    private static Logger log = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping(value = "/uploadInit", method = RequestMethod.GET)
    public String fileUpload() {

        return "/upload/fileUpload";
    }

    @PostMapping(value = "/upload1")
    public String fileUpload(@RequestParam("file") CommonsMultipartFile file) throws IOException {

        if (!file.isEmpty()) {
            log.debug("file is name:{}", file.getOriginalFilename());
            FileUtils.copyInputStreamToFile(file.getInputStream(),
                    new File("D:/", System.currentTimeMillis() + file.getOriginalFilename()));
        }

        return "hello";
    }

    @PostMapping("/upload2")
    public String fileUpload2(@RequestParam("file") CommonsMultipartFile file) throws IOException {
        //把文件名前面加一个当前时间
        String path = "D:/" + new Date().getTime() + file.getOriginalFilename();

        File newFile = new File(path);
        //通过CommonsMultipartFile的方法直接写文件（注意这个时候）
        file.transferTo(newFile);

        return "hello";
    }

    @PostMapping("/upload3")
    public String springUpload(HttpServletRequest request) throws IllegalStateException, IOException {

        //将当前上下文初始化给  CommonsMutipartResolver （多部分解析器）
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
        //检查form中是否有enctype="multipart/form-data"
        if (multipartResolver.isMultipart(request)) {
            //将request变成多部分request
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
            //获取multiRequest 中所有的文件名
            Iterator iter = multiRequest.getFileNames();

            while (iter.hasNext()) {
                //一次遍历所有文件
                MultipartFile file = multiRequest.getFile(iter.next().toString());
                if (file != null) {
                    String path = "D:/" + file.getOriginalFilename();
                    //上传
                    file.transferTo(new File(path));
                }
            }
        }

        return "hello";
    }


    @PostMapping("/upload4")
    public String upload(@RequestParam("files") MultipartFile[] files) {
        try {
            for (int i = 0; i < files.length; i++) {
                FileUtils.writeByteArrayToFile(new File("d:/upload/" + files[i].getOriginalFilename()), files[i].getBytes());
            }
            return "hello";
        } catch (IOException e) {
            e.printStackTrace();
            return "hello";
        }
    }

}
