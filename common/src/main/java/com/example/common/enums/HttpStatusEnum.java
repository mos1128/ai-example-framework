package com.example.common.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Http状态返回枚举
 *
 * @author mos
 **/
@Getter
@RequiredArgsConstructor
public enum HttpStatusEnum {

    /**
     * 操作成功
     */
    SUCCESS(200, "操作成功"),
    /**
     * 操作成功
     */
    FAIL(-1, "操作失败"),
    /**
     * 参数列表错误（缺少，格式不匹配）
     */
    BAD_REQUEST(400, "参数列表错误"),
    /**
     * 未授权
     */
    UNAUTHORIZED(401, "访问未授权"),
    /**
     * 访问受限，授权过期
     */
    FORBIDDEN(403, "访问受限"),
    /**
     * 系统内部错误
     */
    ERROR(500, "系统内部错误");

    private final Integer code;
    private final String message;
}
