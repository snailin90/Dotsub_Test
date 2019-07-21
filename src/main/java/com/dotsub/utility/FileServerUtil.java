package com.dotsub.utility;

import java.io.File;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Snailin Inoa
 */
public class FileServerUtil {

    private final static Logger LOGGER = LoggerFactory.getLogger(FileServerUtil.class);

    public static void saveFileInServer(MultipartFile multipartFile, Long fileInfoId) throws IOException {
        LOGGER.info("File Original Name :: " + multipartFile.getOriginalFilename());
        LOGGER.info(" Name :: " + multipartFile.getName());
        LOGGER.info("Content Type :: " + multipartFile.getContentType());
        File folder = new ClassPathResource(Constant.SERVER_FILE_FOLDER).getFile();
        File fileUpload = new File(folder.getPath() + "/id_" + fileInfoId + "_" + multipartFile.getOriginalFilename());
        multipartFile.transferTo(fileUpload);
    }

}
