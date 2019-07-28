package com.dotsub.controller;

import com.dotsub.dto.GenericModelDTO;
import com.dotsub.model.FileInfo;
import com.dotsub.service.IFileInfoService;
import com.dotsub.utility.Constant;
import com.dotsub.utility.FileServerUtil;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
    public ResponseEntity<GenericModelDTO<FileInfo>> uploadFile(@RequestPart(value = "file", required = true) MultipartFile multipartFile,
            @RequestParam(name = "title") String fileTitle,
            @RequestParam(name = "description") String description,
            @RequestParam(name = "creationDate") Long creationDate) {

        LOGGER.debug("Title :: " + fileTitle);
        LOGGER.debug("description :: " + description);
        LOGGER.debug("creationDate :: " + creationDate);

        GenericModelDTO<FileInfo> genericModelDTO = new GenericModelDTO<>();
        try {

            FileInfo fileInfo = new FileInfo();
            fileInfo.setTitle(fileTitle);
            fileInfo.setFileOriginalName(multipartFile.getOriginalFilename());
            fileInfo.setDescription(description);
            fileInfo.setCreationDate(new Date(creationDate));

            FileInfo fileInfoCreated = fileInfoService.create(fileInfo);

            if (fileInfoCreated != null && fileInfoCreated.getId() != null && fileInfoCreated.getId() > 0) {
                String fileUrl = FileServerUtil.saveFileInServer(multipartFile, fileInfoCreated.getId());
                fileInfoCreated.setFileUploadUrl(fileUrl);
                fileInfoCreated = fileInfoService.update(fileInfoCreated);
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

    @RequestMapping(value = "/root-directory", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getRootDirectory() {
        String rootDirectoryPath = FileServerUtil.getRootDirectoryPath();
        LOGGER.info("rootDirectoryPath :: " + rootDirectoryPath);
        Map map = new HashMap();
        map.put("rootDirectoryPath", rootDirectoryPath);
        return ResponseEntity.ok(map);
    }

}
