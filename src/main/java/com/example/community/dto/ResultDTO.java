package com.example.community.dto;

import com.example.community.Exception.CustomizedErrorCode;
import com.example.community.Exception.CustomizedException;
import lombok.Data;

@Data
public class ResultDTO<T> {
    private String message;
    private Integer code;
    private T data;

    public static ResultDTO errorOf(Integer code, String message) {
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setCode(code);
        resultDTO.setMessage(message);
        return resultDTO;
    }

    public static ResultDTO errorOf(CustomizedErrorCode errorCode) {
        return errorOf(errorCode.getCode(), errorCode.getMessage());
    }

    public static ResultDTO errorOf(CustomizedException e) {
        return errorOf(e.getCode(), e.getMessage());
    }

    public static ResultDTO success() {
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setCode(200);
        resultDTO.setMessage("Request success");
        return resultDTO;
    }

    public static <T> ResultDTO success(T t) {
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setCode(200);
        resultDTO.setMessage("Request success");
        resultDTO.setData(t);
        return resultDTO;
    }
}
