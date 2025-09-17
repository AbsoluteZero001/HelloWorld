package com.springboot.springboot.pojo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "统一响应对象，封装接口返回的数据、状态码和提示信息")
public class ResponsePojo<T> {

    @Schema(description = "响应的数据")
    private T data;

    @Schema(description = "响应的说明信息")
    private String message;

    @Schema(description = "响应状态码，1:成功，2:失败")
    private int code; // 成功为1，失败为2

    // 构造方法私有化
    private ResponsePojo(T data) {
        this.data = data;
        this.code = 1;
        this.message = "";
    }

    private ResponsePojo(T data, String message, int code) {
        this.data = data;
        this.code = code;
        this.message = message;
    }

    // 静态方法
    public static <T> ResponsePojo<T> success(T data) {
        return new ResponsePojo<>(data);
    }

    public static <T> ResponsePojo<T> fail(T data, String message) {
        return new ResponsePojo<>(data, message, 2);
    }
}
