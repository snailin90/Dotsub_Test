package com.dotsub.service;

import com.dotsub.model.FileInfo;

/**
 *
 * @author Snailin Inoa
 */
public interface IFileInfoService {

    public FileInfo create(FileInfo fileInfo) throws Exception;

    public FileInfo update(FileInfo fileInfo) throws Exception;

}
