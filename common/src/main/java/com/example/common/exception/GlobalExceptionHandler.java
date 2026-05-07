package com.example.common.exception;

import com.example.common.base.Result;
import com.example.common.enums.HttpStatusEnum;
import io.swagger.v3.oas.annotations.Hidden;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

/**
 * 全局异常处理器<br/>
 * 指定@Hidden注解让文档不扫描当前类
 *
 * @author mos
 */
@Hidden
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Valid参数校验失败异常
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result<Object> handleValidException(MethodArgumentNotValidException e) {
        String message = e.getBindingResult().getFieldErrors().stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .collect(Collectors.joining("; "));
        log.error("参数校验失败：{}", message);
        return Result.fail(HttpStatusEnum.BAD_REQUEST, message);
    }

    /**
     * 表单参数校验异常（非JSON请求）
     */
    @ExceptionHandler(BindException.class)
    public Result<Object> handleBindException(BindException e) {
        String message = e.getBindingResult().getFieldErrors().stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .collect(Collectors.joining("; "));
        log.error("表单参数校验失败：{}", message);
        return Result.fail(HttpStatusEnum.BAD_REQUEST, message);
    }

    /**
     * 自定义异常
     */
    @ExceptionHandler(BusinessException.class)
    public Result<Object> businessExceptionHandle(BusinessException e) {
        log.error("自定义异常：{}", e.getMessage());
        return Result.fail(e.getHttpStatus(), e.getMessage());
    }

    /**
     * 全局异常
     */
    @ExceptionHandler(Exception.class)
    public Result<Object> exceptionHandle(Exception e) {
        log.error("未知异常：", e);
        return Result.fail(HttpStatusEnum.ERROR, null);
    }
}
