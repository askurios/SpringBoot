package com.sample.multipart.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

@RestController
public class RestApiController {
    private static final Logger logger = LoggerFactory.getLogger(RestApiController.class);

    @RequestMapping("/uploadSuwonEvent")
    public String uploadResources(HttpServletRequest servletRequest,
                                  @ModelAttribute MultipartVO multipartVO,
                                  Model model) {
        multipartVO.getData();

        List<MultipartFile> files = multipartVO.getFiles();
        List<String> fileNames = new ArrayList<String>();

        if (null != files && files.size() > 0) {
            for (MultipartFile multipartFile : files) {

                String fileName = multipartFile.getOriginalFilename();
                fileNames.add(fileName);
                File file = new File("/Users/limecode/temp/files", fileName);

                logger.info(file.getAbsolutePath());

                try {
                    multipartFile.transferTo(file);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return multipartVO.getData();
    }


}