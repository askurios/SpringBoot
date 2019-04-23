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
    private static final String FILE_HOME ="/Users/limecode/temp/files";

    @RequestMapping("/uploadEvent")
    public String uploadEvent(HttpServletRequest servletRequest,
                                  @ModelAttribute MultipartVO multipartVO,
                                  Model model) {
        multipartVO.getData();

        if (null != multipartVO.getFL01()) saveFile(multipartVO.getFL01());
        if (null != multipartVO.getFL02()) saveFile(multipartVO.getFL02());
        if (null != multipartVO.getFL03()) saveFile(multipartVO.getFL03());
        if (null != multipartVO.getFL04()) saveFile(multipartVO.getFL04());
        if (null != multipartVO.getFL05()) saveFile(multipartVO.getFL05());
        if (null != multipartVO.getFL06()) saveFile(multipartVO.getFL06());
        if (null != multipartVO.getFL07()) saveFile(multipartVO.getFL07());

        return multipartVO.getData();
    }

    void saveFile(MultipartFile mfile){
        List<String> fileNames = new ArrayList<String>();

        String fileName = mfile.getOriginalFilename();
        fileNames.add(fileName);

        File file = new File(FILE_HOME, fileName);
        logger.info(file.getAbsolutePath());

        try {
            mfile.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}