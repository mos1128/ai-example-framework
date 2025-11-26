package com.mos.example.controller;

import com.baomidou.dynamic.datasource.annotation.DSTransactional;
import com.mos.example.service.DsTService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 多数据源事务示例接口</br>
 * 本类仅用于演示用法，无实际意义
 *
 * @author ly
 */
@RestController
@RequestMapping("dst")
@RequiredArgsConstructor
public class DsTController {

    private final DsTService dsTService;

    @GetMapping("start")
    @DSTransactional
    public void start() {
        dsTService.insert2A();
        // 单源失败回滚测试
        // System.out.println(2 / 0);
        dsTService.insert2B();
        // 多源失败回滚测试
        System.out.println(2 / 0);
    }
}
