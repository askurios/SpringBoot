package com.sample.multipart.demo;

import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotNull;

public class MultipartVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull
    private String data;

    private List<MultipartFile> files;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public List<MultipartFile> getFiles() {
        return files;
    }

    public void setFiles(List<MultipartFile> files) {
        this.files = files;
    }
}
