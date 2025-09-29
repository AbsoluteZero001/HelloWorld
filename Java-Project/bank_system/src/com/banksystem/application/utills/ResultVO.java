package com.banksystem.application.utills;
// json响应体数据格式
public class ResultVO<T> {
    private String code;
    private String message;
    private Boolean success;
    private T data;
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public Boolean getSuccess() {
        return success;
    }
    public void setSuccess(Boolean success) {
        this.success = success;
    }
    public T getData() {
        return data;
    }
    public void setData(T data) {
        this.data = data;
    }
    public ResultVO(){
    }
    public ResultVO(T data){
        this.setCode("200"); // 状态码
        this.setSuccess(Boolean.TRUE); // 成功与否的布尔值
        this.setMessage(null); // 提示信息
        this.setData(data); // 返回的数据
    }
}
