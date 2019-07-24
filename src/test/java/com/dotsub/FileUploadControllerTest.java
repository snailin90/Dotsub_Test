/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dotsub;

import java.io.IOException;
import java.io.InputStream;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 *
 * @author sinoa
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class FileUploadControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testUploadApi() throws IOException, Exception {
        try {
            InputStream inputStream = new ClassPathResource("testFile.txt").getInputStream();
            MockMultipartFile mockMultipartFile = new MockMultipartFile("file", "testFile.txt", "multipart/form-data", inputStream);
            mockMvc.perform(MockMvcRequestBuilders.multipart("/api/file/upload").file(mockMultipartFile).file("file", mockMultipartFile.getBytes()))
                    .andExpect(MockMvcResultMatchers.status().is(200)).andReturn();

        } catch (IOException ex) {

        }

    }

}
