package com.dotsub.repository;

import com.dotsub.model.FileInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Snailin Inoa
 */
@Repository
public interface FileInfoRepository extends JpaRepository<FileInfo, Long> {

}
