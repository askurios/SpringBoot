package com.sample.multipart.demo;

import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotNull;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class MultipartVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull
    private String data;

//    private List<MultipartFile> files;
//    private MultipartFile files;
    private MultipartFile FL01;
//    private List<MultipartFile> FL02;
//    private List<MultipartFile> FL04;
    private MultipartFile FL02;
    private MultipartFile FL03;
    private MultipartFile FL04;
    private MultipartFile FL05;
    private MultipartFile FL06;
    private MultipartFile FL07;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public MultipartFile getFL01() {
        return FL01;
    }

    public void setFL01(MultipartFile FL01) {
        this.FL01 = FL01;
    }

//    public List<MultipartFile> getFL02() {
//        return FL02;
//    }
//
//    public void setFL02(List<MultipartFile> FL02) {
//        this.FL02 = FL02;
//    }
//
//    public List<MultipartFile> getFL04() {
//        return FL04;
//    }
//
//    public void setFL04(List<MultipartFile> FL04) {
//        this.FL04 = FL04;
//    }


    public MultipartFile getFL02() {
        return FL02;
    }

    public void setFL02(MultipartFile FL02) {
        this.FL02 = FL02;
    }

    public MultipartFile getFL03() {
        return FL03;
    }

    public void setFL03(MultipartFile FL03) {
        this.FL03 = FL03;
    }

    public MultipartFile getFL04() {
        return FL04;
    }

    public void setFL04(MultipartFile FL04) {
        this.FL04 = FL04;
    }

    public MultipartFile getFL05() {
        return FL05;
    }

    public void setFL05(MultipartFile FL05) {
        this.FL05 = FL05;
    }

    public MultipartFile getFL06() {
        return FL06;
    }

    public void setFL06(MultipartFile FL06) {
        this.FL06 = FL06;
    }

    public MultipartFile getFL07() {
        return FL07;
    }

    public void setFL07(MultipartFile FL07) {
        this.FL07 = FL07;
    }
}
