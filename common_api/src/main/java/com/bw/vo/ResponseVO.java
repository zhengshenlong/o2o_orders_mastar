package com.bw.vo;


import lombok.Data;

@Data
public class ResponseVO<T> {//泛型类

    private int code;
    private String msg;
    private T data;

    public void setCode(int code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }

    public static <T> ResponseVO success(T data){//泛型方法
        ResponseVO responseVO = new ResponseVO();
        responseVO.setData(data);
        responseVO.setMsg(CodeMsg.SUCCESS.getMsg());
        responseVO.setCode(CodeMsg.SUCCESS.getCode());
        return responseVO;
    }

    public static <T> ResponseVO error(CodeMsg codeMsg){//泛型方法
        ResponseVO responseVO = new ResponseVO();
        responseVO.setCode(codeMsg.getCode());
        responseVO.setMsg(codeMsg.getMsg());
        return responseVO;
    }


}
