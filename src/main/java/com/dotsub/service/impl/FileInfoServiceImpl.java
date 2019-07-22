package com.dotsub.service.impl;

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
}
