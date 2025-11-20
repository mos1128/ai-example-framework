package com.mos.base.common.utils;

import cn.dev33.satoken.stp.StpUtil;
import com.mos.base.common.base.HttpStatusEnum;
import com.mos.base.common.exception.BusinessException;
import com.mos.base.common.vo.UserInfo;

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
