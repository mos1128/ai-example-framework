package com.example.core.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.bean.BeanUtil;
import com.example.common.base.PageQuery;
import com.example.common.base.RPage;
import com.example.common.base.UserInfo;
import com.example.common.exception.BusinessException;
import com.example.common.utils.PageUtil;
import com.example.core.domain.User;
import com.example.core.dto.UserLoginDto;
import com.example.core.mapper.UserMapper;
import com.example.core.service.UserService;
import com.example.core.vo.UserVo;
import com.mybatisflex.annotation.UseDataSource;
import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.query.QueryWrapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户服务实现类
 *
 * @author ly
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserInfo login(UserLoginDto userLoginDto) {
        User user = userMapper.selectOneByQuery(QueryWrapper.create()
                .eq(User::getUsername, userLoginDto.getUsername()));
        if (user == null) {
            throw new BusinessException("用户不存在");
        }
        if (!passwordEncoder.matches(userLoginDto.getPassword(), user.getPassword())) {
            throw new BusinessException("账号密码错误");
        }

        StpUtil.login(user.getUserId());
        UserInfo userInfo = BeanUtil.copyProperties(user, UserInfo.class);
        userInfo.setToken(StpUtil.getTokenValue());
        StpUtil.getTokenSession().set("user", userInfo);
        return userInfo;
    }

    @Override
    @UseDataSource("test")
    public RPage<UserVo> page(PageQuery pageQuery) {
        QueryWrapper queryWrapper = QueryWrapper.create();
        PageUtil.addOrder(queryWrapper, pageQuery.getOrder());
        Page<User> page = userMapper.paginate(pageQuery.getPageNo(), pageQuery.getPageSize(), queryWrapper);
        List<UserVo> users = BeanUtil.copyToList(page.getRecords(), UserVo.class);
        return RPage.build(users, pageQuery.getPageNo(), pageQuery.getPageSize(), page.getTotalRow());
    }
}
