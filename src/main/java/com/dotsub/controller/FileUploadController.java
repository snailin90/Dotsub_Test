package com.dotsub.controller;

import com.dotsub.dto.GenericModelDTO;
import com.dotsub.model.FileInfo;
import com.dotsub.service.IFileInfoService;
import com.dotsub.utility.Constant;
import com.dotsub.utility.FileServerUtil;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("/api/file")
public class FileUploadController {

    public final IFileInfoService fileInfoService;
    private final static Logger LOGGER = LoggerFactory.getLogger(FileUploadController.class);

    public FileUploadController(IFileInfoService fileInfoService) {
        this.fileInfoService = fileInfoService;
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericModelDTO<FileInfo>> uploadFile(@RequestPart(value = "file", required = true) MultipartFile multipartFile) {
        GenericModelDTO<FileInfo> genericModelDTO = new GenericModelDTO<>();
        try {

            FileInfo fileInfo = new FileInfo();
            fileInfo.setTitle(multipartFile.getOriginalFilename());
            String description = "File Name: " + multipartFile.getOriginalFilename() + ", Content Type : " + multipartFile.getContentType() + ", Size :(" + multipartFile.getSize() + ") Bytes";
            fileInfo.setDescription(description);
            fileInfo.setCreationDate(new Date());

            FileInfo fileInfoCreated = fileInfoService.create(fileInfo);

            if (fileInfoCreated != null && fileInfoCreated.getId() != null && fileInfoCreated.getId() > 0) {
                FileServerUtil.saveFileInServer(multipartFile, fileInfoCreated.getId());
            }
            genericModelDTO.setSingleObject(fileInfoCreated);
            genericModelDTO.setCode(Constant.SUCCESS_CODE);
            genericModelDTO.setMessage(Constant.SUCCESS_MSG);

        } catch (Exception ex) {
            genericModelDTO.setCode(Constant.ERROR_CODE);
            genericModelDTO.setMessage("Error have occurred :: " + ex.getMessage());
            LOGGER.error("Error : " + ex);
            ex.printStackTrace();
        }

        return ResponseEntity.ok(genericModelDTO);
    }

}
