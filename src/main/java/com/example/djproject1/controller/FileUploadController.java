//package com.example.djproject1.controller;
//
//
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import org.springframework.web.HttpSessionRequiredException;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.File;
//import java.io.IOException;
//
//@RestController
//public class FileUploadController {
//
//    @PostMapping("/upload")
//    public String up(String  nickname, MultipartFile photo, HttpServletRequest request) throws IOException{
//        System.out.println(nickname);
//        // 获取图片的原始名称
//        System.out.println(photo.getOriginalFilename());
//        // 获取文件类型
//        System.out.println(photo.getContentType());
////        System.out.println(System.getProperty("user.dir"));
//
//        //获取web服务器的运行目录
//        String path = request.getServletContext().getRealPath("/upload/");
//        System.out.println(path);
//        saveFile(photo,path);
//        return "上传成功";
//
//    }
//
//    private void saveFile(MultipartFile photo, String path) throws IOException{
//        File dir = new File(path);
//        if(!dir.exists()){
//            //创建目录
//            dir.mkdir();
//        }
//
//        File file = new File(path+photo.getOriginalFilename());
//        photo.transferTo(file);
//
//    }
//}
//
//


package com.example.djproject1.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.util.ResourceUtils;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
public class FileUploadController {

    private final ResourceLoader resourceLoader;

    public FileUploadController(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @PostMapping("/upload")
    public String up(String nickname, MultipartFile photo, HttpServletRequest request) throws IOException {
        System.out.println(nickname);
        // 获取图片的原始名称
        System.out.println(photo.getOriginalFilename());
        // 获取文件类型
        System.out.println(photo.getContentType());

        // 获取static目录的绝对路径
        String staticPath = ResourceUtils.getFile("classpath:static").getAbsolutePath();
        String uploadPath = staticPath + File.separator + "upload" + File.separator;
        System.out.println(uploadPath);
        saveFile(photo, uploadPath);
        return "上传成功";
    }

    private void saveFile(MultipartFile photo, String path) throws IOException {
        File uploadDir = new File(path);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }

        Path filePath = Paths.get(path + photo.getOriginalFilename());
        Files.write(filePath, photo.getBytes());
    }
}
