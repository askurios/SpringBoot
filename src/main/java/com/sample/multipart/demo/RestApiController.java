package com.sample.multipart.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.StandardMultipartHttpServletRequest;
import org.w3c.dom.Entity;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.Response;

@RestController
public class RestApiController {
    private static final Logger logger = LoggerFactory.getLogger(RestApiController.class);

    @RequestMapping("/uploadEvent")
    public String uploadResources(HttpServletRequest servletRequest,
                                  @ModelAttribute MultipartVO multipartVO,
                                               Model model) {
        multipartVO.getData();

        MultipartFile files01 = multipartVO.getFL01();
        MultipartFile files02 = multipartVO.getFL02();
        MultipartFile files03 = multipartVO.getFL03();
        MultipartFile files04 = multipartVO.getFL04();
        MultipartFile files05 = multipartVO.getFL05();
        MultipartFile files06 = multipartVO.getFL06();
        MultipartFile files07 = multipartVO.getFL07();

        transferFile(files01);
        transferFile(files02);
        transferFile(files03);
        transferFile(files04);
        transferFile(files05);
        transferFile(files06);
        transferFile(files07);




//        List<MultipartFile> files02 = multipartVO.getFL02();
//        List<MultipartFile> files04 = multipartVO.getFL04();
//        List<String> fileNames02 = new ArrayList<String>();
//        List<String> fileNames04 = new ArrayList<String>();

//        if (null != files01) {
////            for (MultipartFile multipartFile : files02) {
//
//                String fileName = files01.getOriginalFilename();
//                fileNames02.add(fileName);
//                File file = new File("/Users/limecode/temp/2019Suwon/receivedFiles", fileName);
//
//                logger.info(file.getAbsolutePath());
//
//                try {
//                    files01.transferTo(file);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
////            }
//        }
//
//        if (null != files02 && files02.size() > 0) {
//            for (MultipartFile multipartFile : files02) {
//
//                String fileName = multipartFile.getOriginalFilename();
//                fileNames02.add(fileName);
//                File file = new File("/Users/limecode/temp/2019Suwon/receivedFiles", fileName);
//
//                logger.info(file.getAbsolutePath());
//
//                try {
//                    multipartFile.transferTo(file);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//
//        if (null != files04 && files04.size() > 0) {
//            for (MultipartFile multipartFile : files04) {
//
//                String fileName = multipartFile.getOriginalFilename();
//                fileNames04.add(fileName);
//                File file = new File("/Users/limecode/temp/2019Suwon/receivedFiles", fileName);
//
//                logger.info(file.getAbsolutePath());
//
//                try {
//                    multipartFile.transferTo(file);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }

        multipartVO.setData("{\"resultMsg\":\"정상\",\"resultCode\":\"0\"}");
        return multipartVO.getData();
//        model.addAttribute("resultCode",0);
//        EventSequence:1 , Response:{"resultMsg":"정상","resultCode":"0"}
//        return "{'resultMsg':'정상','resultCode':'0'}";
//
//        Map map = new HashMap();
//        map.put("resultCode",0);
//        return "{'resultCode':'0'}";
//        List<JSONObject> entities = new ArrayList<JSONObject>();
//        for (Entity n : entityList) {
//            JSONObject entity = new JSONObject();
//            entity.put("aa", "bb");
//            entities.add(entity);
//        }
//        return new ResponseEntity<Object>(entities, HttpStatus.OK);
    }

    private void transferFile(MultipartFile multifile) {
        if (multifile == null) {
            return;
        }
        String fileName = multifile.getOriginalFilename();
//                fileNames02.add(fileName);
        File file = new File("/Users/limecode/temp/2019Suwon/receivedFiles", fileName);

        logger.info(file.getAbsolutePath());

        try {
            multifile.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/test")
    public ResponseEntity<String> test(HttpServletRequest servletRequest,
                         @ModelAttribute MultipartVO multipartVO,
                         Model model) {

        model.addAttribute("resultCode",0);
//        return model.toString();
//        ResponseEntity<String> entity = new ResponseEntity<>();

        return new ResponseEntity<String>("{'resultCode':'0'}", HttpStatus.OK);

    }

    @GetMapping(path = "/hello", produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> sayHello() throws JSONException {
        //Get data from service layer into entityList.

        List<JSONObject> entities = new ArrayList<JSONObject>();
//        for (Entity n : entityList) {
            JSONObject entity = new JSONObject();
            entity.put("aa", "bb");
            entities.add(entity);
//        }
        return new ResponseEntity<Object>(entities, HttpStatus.OK);
    }


}