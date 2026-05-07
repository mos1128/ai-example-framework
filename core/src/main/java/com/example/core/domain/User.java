package com.example.core.domain;

import com.mybatisflex.annotation.Column;
import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 用户实体类
 * @author ly
 */
@Data
@Accessors(chain = true)
@Table("user")
public class User implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id(keyType = KeyType.Auto)
    private Integer userId;

    @Schema(description = "账号")
    private String username;

    @Schema(description = "密码")
    private String password;

    @Schema(description = "联系电话")
    private String phone;

    @Schema(description = "创建时间")
    @Column(onInsertValue = "now()")
    private LocalDateTime createTime;

    @Schema(description = "修改时间")
    @Column(onInsertValue = "now()", onUpdateValue = "now()")
    private LocalDateTime updateTime;

    @Schema(description = "是否删除")
    @Column(isLogicDelete = true)
    private Boolean isDeleted;

    @Schema(description = "版本")
    @Column(version = true)
    private Integer version;
}
