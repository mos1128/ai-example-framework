package com.mos.example.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.mos.example.domain.Dst;
import com.mos.example.mapper.DstMapper;
import com.mos.example.service.DsTService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * 多数据源事务示例<br/>
 * 本类仅用于演示用法，无实际意义
 *
 * @author ly
 */
@Service
@RequiredArgsConstructor
public class DsTServiceImpl implements DsTService {

    private final DstMapper dstMapper;

    @Override
    @DS("master")
    public Integer insert2A() {
        String now = "A" + LocalDateTime.now();
        Dst dst = new Dst();
        dst.setNumber(now);
        dst.setNickname(now);
        dstMapper.insert(dst);
        return dst.getUserId();
    }

    @Override
    @DS("test")
    public Integer insert2B() {
        String now = "B" + LocalDateTime.now();
        Dst dst = new Dst();
        dst.setNumber(now);
        dst.setNickname(now);
        dstMapper.insert(dst);
        return dst.getUserId();
    }
}
