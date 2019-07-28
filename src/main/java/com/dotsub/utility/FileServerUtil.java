package com.dotsub.utility;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.filechooser.FileSystemView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
     * server , in the Root Directory of the Operating System (OS)
     *
     * Note: Root Directory will vary depending in the OS and the configuration
     *
     */
    public static String saveFileInServer(MultipartFile multipartFile, Long fileInfoId) throws IOException {
        LOGGER.debug("File Original Name :: " + multipartFile.getOriginalFilename());
        LOGGER.debug(" Name :: " + multipartFile.getName());
        LOGGER.debug("Content Type :: " + multipartFile.getContentType());
        FileSystemView fsv = FileSystemView.getFileSystemView();
        File rootDirectory = fsv.getDefaultDirectory();
        LOGGER.info("Root Directory :: " + rootDirectory.getPath());
        boolean folderExist = new File(fsv.getDefaultDirectory() + "/" + Constant.SERVER_FILE_FOLDER).exists();
        if (!folderExist) {
            LOGGER.info("Preparing for create the folder in the root directory [folder_upload]");
            Path path = Paths.get(fsv.getDefaultDirectory() + "/" + Constant.SERVER_FILE_FOLDER);
            Files.createDirectories(path);

        }
        File fileUpload = new File(fsv.getDefaultDirectory() + "/" + Constant.SERVER_FILE_FOLDER + "/id_" + fileInfoId + "_" + multipartFile.getOriginalFilename());
        multipartFile.transferTo(fileUpload);
        return fileUpload.getPath();
    }

    /**
     *
     * @return
     *
     * This method return the path of the root directory where the application
     * is deployed.
     */
    public static String getRootDirectoryPath() {
        FileSystemView fsv = FileSystemView.getFileSystemView();
        File rootDirectory = fsv.getDefaultDirectory();
        return rootDirectory.getPath();
    }

}
