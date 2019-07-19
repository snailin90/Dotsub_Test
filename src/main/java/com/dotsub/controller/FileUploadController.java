package com.dotsub.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author sinoa
 */
@RestController
@RequestMapping("/file")
public class FileUploadController {

    @RequestMapping(value = "/upload", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public void uploadFile(@RequestPart(value = "file", required = true) MultipartFile file) {

        try {
            System.out.println("File :: " + file.getName());
            System.out.println("File Original Name :: " + file.getOriginalFilename());

            System.out.println("Description:: " + file.getResource().getDescription());
            System.out.println("Description:: " + file.getContentType());

//            System.out.println("File Object:: " + file.getResource().getFile());

//            Path path = file.getInputStream().
//
//            BasicFileAttributes fatr = Files.readAttributes(path, BasicFileAttributes.class);
//            System.out.println("Creation DATE :: " + fatr.creationTime());
        } catch (Exception ex) {
            Logger.getLogger(FileUploadController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
