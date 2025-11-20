package com.mos.base.core.service;

import com.mos.base.common.dto.SmsCaptchaDto;
import com.mos.base.common.dto.UserLoginDto;
import com.mos.base.common.dto.UserSmsLoginDto;
import com.mos.base.common.vo.UserInfo;

import java.util.Map;

/**
 * 认证服务
 * @author ly
 */
public interface AuthService {

    /**
     * 获取图片验证码
     *
     * @return
     */
    Map<String, String> getPicCaptcha();

    /**
     * 获取短信验证码
     */
    void getSmsCaptcha(SmsCaptchaDto smsCaptchaDto);

    /**
     * 密码登录
     *
     * @param userLoginDto
     * @return
     */
    UserInfo login(UserLoginDto userLoginDto);

    /**
     * 短信验证码登录
     *
     * @param userSmsLoginDto
     * @return
     */
    UserInfo smsLogin(UserSmsLoginDto userSmsLoginDto);

}
