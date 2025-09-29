package com.springboot.springboot2.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponsePojo<T> {
    private Integer code;
    private String message;
    private T data;

    public static <T> ResponsePojo<T> success(T data) {
        return new ResponsePojo<>(200, "成功", data);
    }

    public static <T> ResponsePojo<T> fail(T data, String message) {
        return new ResponsePojo<>(500, message, data);
    }
}
