package com.uashuke.livefeed.usernotes.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;

@Getter
@Setter
@ToString
public class ApiResponse {
    private int responseCode;
    private String responseMessage;
    private Object data;

    public ApiResponse(){
        responseCode = 200;
        responseMessage = "Success";
    }

    public ApiResponse(String objectType){
        this();
        if(objectType.equals("array")){
            data = new ArrayList<>();
        }
    }
}
