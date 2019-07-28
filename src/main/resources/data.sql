/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  sinoa
 * Created: Jul 19, 2019
 */

DROP TABLE IF EXISTS file_info;
 
CREATE TABLE file_info (
  id bigint  AUTO_INCREMENT  PRIMARY KEY,
  title VARCHAR(250) NOT NULL,
  description TEXT,
  creation_date timestamp,
  file_url varchar(500) ,
  file_original_name varchar(250)

);