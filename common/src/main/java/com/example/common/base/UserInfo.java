package com.example.common.base;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 已登录用户信息
 *
 * @author ly
 */
@Data
@Accessors(chain = true)
public class UserInfo {

    @Schema(description = "token")
    private String token;

    @Schema(description = "用户id")
    private Integer userId;

    @Schema(description = "账号")
    private String username;
}
