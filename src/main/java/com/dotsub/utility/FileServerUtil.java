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

    /**
     *
     * @param multipartFile
     * @param fileInfoId
     * @throws IOException
     *
     * This method will take the incoming file and will save it in the local
     * server , in the [target] folder of the project URL Example : /Dotsub_Test/target/classes/files
     */
    public static void saveFileInServer(MultipartFile multipartFile, Long fileInfoId) throws IOException {
        LOGGER.debug("File Original Name :: " + multipartFile.getOriginalFilename());
        LOGGER.debug(" Name :: " + multipartFile.getName());
        LOGGER.debug("Content Type :: " + multipartFile.getContentType());
        File folder = new ClassPathResource(Constant.SERVER_FILE_FOLDER).getFile();
        File fileUpload = new File(folder.getPath() + "/id_" + fileInfoId + "_" + multipartFile.getOriginalFilename());
        multipartFile.transferTo(fileUpload);
    }

}
