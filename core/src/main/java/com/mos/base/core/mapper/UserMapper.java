package com.mos.base.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mos.base.common.domain.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author ly
 * @since 2025/5/16
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
