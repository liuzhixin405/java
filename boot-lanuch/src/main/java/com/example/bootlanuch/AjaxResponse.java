package com.example.bootlanuch;

import lombok.Data;

@Data
public class AjaxResponse {
    private boolean isok;
    private  int code;
    private  String message;
    private Object data;

    public AjaxResponse(){}

    public  static AjaxResponse success(Object obj){
        AjaxResponse response =  new AjaxResponse();
        response.setIsok(true);
        response.setMessage("success");
        response.setData(obj);
        response.setCode(200);
        return response;
    }

    public  static AjaxResponse success(){
        AjaxResponse response =  new AjaxResponse();
        response.setIsok(true);
        response.setMessage("success");
        response.setCode(200);
        return response;
    }
    public  static  AjaxResponse fail(){
        AjaxResponse response =  new AjaxResponse();
        response.setIsok(false);
        response.setMessage("fail");
        response.setCode(200);
        return response;
    }
}
