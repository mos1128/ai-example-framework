package com.mos.example.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;

/**
 * 用户实体类
 *
 * @author ly
 */
@Data
@Accessors(chain = true)
public class Dst implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @TableId(value = "user_id", type = IdType.AUTO)
    private Integer userId;

    /**
     * 用户编号
     */
    private String number;

    /**
     * 用户昵称
     */
    private String nickname;

}
