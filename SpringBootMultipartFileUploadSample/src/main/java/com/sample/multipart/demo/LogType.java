package com.sample.multipart.demo;

public enum LogType {

    NORMAL(0, "정상"),
    ERROR_DATA(-10, "데이터 오류"),
    ERROR_FILE(-20, "File 오류"),
    ERROR_DB(-30, "DB오류"),
    ERROR_ETC(-40, "기타오류");

    private int code;
    private String message;


    LogType(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public static LogType of(int code) {
        for(LogType type : LogType.values()){
            if (type.code == code){
                return type;
            }
        }
        return null;
    }

    public String getMessage() { // 문자를 받아오는 함수
        return message;
    }

}
