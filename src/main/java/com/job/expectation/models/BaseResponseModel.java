package com.job.expectation.models;

public class BaseResponseModel {

    private String Code;
    private String Message;
    private ResponseDataModel Data;

    public BaseResponseModel() {
    }

    public BaseResponseModel(String code, String message, ResponseDataModel data) {
        Code = code;
        Message = message;
        Data = data;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public ResponseDataModel getData() {
        return Data;
    }

    public void setData(ResponseDataModel data) {
        Data = data;
    }

    @Override
    public String toString() {
        return "BaseResponseModel{" +
                "Code='" + Code + '\'' +
                ", Message='" + Message + '\'' +
                ", Data=" + Data +
                '}';
    }
}
