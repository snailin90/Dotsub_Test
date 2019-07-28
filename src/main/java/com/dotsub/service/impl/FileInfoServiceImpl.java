package com.dotsub.service.impl;

import com.dotsub.exception.FileUploadNotFoundException;
import com.dotsub.model.FileInfo;
import com.dotsub.repository.FileInfoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.dotsub.service.IFileInfoService;
import org.springframework.stereotype.Service;

/**
 *
 * @author Snailin Inoa
 */
@Service
public class FileInfoServiceImpl implements IFileInfoService {

    private final FileInfoRepository fileInfoRepository;

    private final Logger LOGGER = LoggerFactory.getLogger(FileInfoServiceImpl.class);

    public FileInfoServiceImpl(FileInfoRepository fileInfoRepository) {
        this.fileInfoRepository = fileInfoRepository;
    }

    /**
     *
     *
     * @param fileInfo
     * @return
     * @throws Exception
     *
     * Save [fileInfo] in the In-Memory H2 database
     */
    @Override
    public FileInfo create(FileInfo fileInfo) throws Exception {
        LOGGER.debug("FileInfo :: " + fileInfo);
        FileInfo result = fileInfoRepository.save(fileInfo);
        return result;

    }

    /**
     *
     * @param fileInfo
     * @return
     * @throws Exception
     *
     * Update [fileInfo] in the In-Memory H2 database
     */
    @Override
    public FileInfo update(FileInfo fileInfo) throws Exception {
        if (fileInfo.getId() == null || fileInfo.getId() <= 0) {
            throw new FileUploadNotFoundException("The ID of the file is not correct. "
                    + "The ID [" + fileInfo.getId() + "]");
        }

        if (!fileInfoRepository.findById(fileInfo.getId()).isPresent()) {
            throw new FileUploadNotFoundException("The File with ID [" + fileInfo.getId() + "] was not Found.");
        }
        FileInfo result = fileInfoRepository.save(fileInfo);

        return result;
    }
}
