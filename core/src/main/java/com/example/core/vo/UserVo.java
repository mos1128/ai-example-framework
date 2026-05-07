package com.example.core.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 用户VO类
 * @author ly
 */
@Data
@Accessors(chain = true)
public class UserVo {

    private Integer userId;

    @Schema(description = "账号")
    private String username;

    @Schema(description = "联系电话")
    private String phone;

}
