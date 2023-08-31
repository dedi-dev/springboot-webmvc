package com.belajar.webmvc.controller;

import java.io.IOException;
import java.nio.file.Path;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {
    
    @PostMapping(path = "/upload/profile")
    @ResponseBody
    public String upload(@RequestParam(name = "name") String name, @RequestPart(name = "profile") MultipartFile profile) throws IllegalStateException, IOException {
        Path path = Path.of("upload/" + profile.getOriginalFilename());
        // Files.write(path, profile.getBytes());
        profile.transferTo(path);
        
        return "Success save profile name : " + name + ", to : " + path;
    }
}
