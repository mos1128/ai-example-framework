package com.example.common.utils;

import cn.dev33.satoken.stp.StpUtil;
import com.example.common.enums.HttpStatusEnum;
import com.example.common.exception.BusinessException;
import com.example.common.base.UserInfo;

/**
 * 用户信息工具类
 *
 * @author mos
 */
public class UserUtil {

    public static UserInfo getUserInfo() {
        if (StpUtil.isLogin()) {
            return (UserInfo) StpUtil.getTokenSession().get("user");
        }
        throw new BusinessException(HttpStatusEnum.UNAUTHORIZED);
    }
}
