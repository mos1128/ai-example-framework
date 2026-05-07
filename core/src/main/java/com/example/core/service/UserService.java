package com.example.core.service;

import com.example.common.base.PageQuery;
import com.example.common.base.RPage;
import com.example.common.base.UserInfo;
import com.example.core.dto.UserLoginDto;
import com.example.core.vo.UserVo;

/**
 * 用户服务
 *
 * @author ly
 */
public interface UserService {

    /**
     * 密码登录
     *
     * @param userLoginDto 用户登录参数
     * @return 用户登录信息
     */
    UserInfo login(UserLoginDto userLoginDto);

    /**
     * 分页查询用户列表
     *
     * @param pageQuery 分页查询参数
     * @return 用户列表
     */
    RPage<UserVo> page(PageQuery pageQuery);
}
