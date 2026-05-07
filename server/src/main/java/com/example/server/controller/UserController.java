package com.example.server.controller;

import com.example.common.base.PageQuery;
import com.example.common.base.RPage;
import com.example.common.base.Result;
import com.example.common.base.UserInfo;
import com.example.core.dto.UserLoginDto;
import com.example.core.service.UserService;
import com.example.core.vo.UserVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 用户接口
 *
 * @author ly
 */
@RestController
@RequestMapping("user")
@RequiredArgsConstructor
@Validated
@Tag(name = "001.用户")
public class UserController {

    private final UserService userService;

    @PostMapping("login")
    @Operation(summary = "密码登录-主数据源")
    public Result<UserInfo> login(@RequestBody @Valid UserLoginDto userLoginDto) {
        return Result.success(userService.login(userLoginDto));
    }

    @GetMapping("list")
    @Operation(summary = "用户分页-test数据源")
    public Result<RPage<UserVo>> list(@Valid PageQuery pageQuery) {
        return Result.success(userService.page(pageQuery));
    }
}
