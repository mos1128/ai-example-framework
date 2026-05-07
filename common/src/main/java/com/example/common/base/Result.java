package com.example.common.base;

import com.example.common.enums.HttpStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Objects;

/**
 * 通用返回结果
 *
 * @author mos
 */
@Data
@AllArgsConstructor
public class Result<T> {

    private Integer code;
    private String msg;
    private T data;

    public static <T> Result<T> success(T data) {
        return new Result<>(HttpStatusEnum.SUCCESS.getCode(), HttpStatusEnum.SUCCESS.getMessage(), data);
    }

    public static <T> Result<T> fail(HttpStatusEnum httpStatus, String message) {
        message = Objects.isNull(message) ? httpStatus.getMessage() : message;
        return new Result<>(httpStatus.getCode(), message, null);
    }
}
