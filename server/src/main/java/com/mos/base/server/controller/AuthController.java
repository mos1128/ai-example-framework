package com.mos.base.server.controller;

import com.mos.base.common.dto.SmsCaptchaDto;
import com.mos.base.common.dto.UserLoginDto;
import com.mos.base.common.dto.UserSmsLoginDto;
import com.mos.base.common.utils.UserUtil;
import com.mos.base.common.vo.UserInfo;
import com.mos.base.core.service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 认证接口
 *
 * @author ly
 */
@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
@Tag(name = "001.认证")
public class AuthController {

    private final AuthService authService;

    @GetMapping("/getUserInfo")
    @Operation(summary = "获取当前用户信息")
    public UserInfo getUserInfo() {
        return UserUtil.getUserInfo();
    }

    @GetMapping("/getPicCaptcha")
    @Operation(summary = "获取图片验证码")
    public Map<String, String> getPicCaptcha() {
        return authService.getPicCaptcha();
    }

    @PostMapping("/getSmsCaptcha")
    @Operation(summary = "获取短信验证码")
    public void getSmsCaptcha(@RequestBody @Valid SmsCaptchaDto smsCaptchaDto) {
        authService.getSmsCaptcha(smsCaptchaDto);
    }

    @PostMapping("login")
    @Operation(summary = "密码登录")
    public UserInfo login(@RequestBody @Valid UserLoginDto userLoginDto) {
        return authService.login(userLoginDto);
    }

    @PostMapping("smsLogin")
    @Operation(summary = "短信验证码登录")
    public UserInfo smsLogin(@RequestBody @Valid UserSmsLoginDto userSmsLoginDto) {
        return authService.smsLogin(userSmsLoginDto);
    }

}
