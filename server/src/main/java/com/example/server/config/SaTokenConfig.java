package com.example.server.config;

import cn.dev33.satoken.filter.SaServletFilter;
import cn.dev33.satoken.router.SaRouter;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.json.JSONUtil;
import com.example.common.base.Result;
import com.example.common.enums.HttpStatusEnum;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * SaToken配置
 *
 * @author mos
 */
@Configuration
public class SaTokenConfig implements WebMvcConfigurer {

    @Bean
    public SaServletFilter getSaServletFilter() {
        return new SaServletFilter()
                .addInclude("/**")
                .addExclude("/favicon.ico", "/index.html",
                        // 放行认证相关
                        "/user/login",
                        // 放行knife4j文档
                        "/doc.html", "/webjars/**", "/swagger-resources/**", "/v3/api-docs/**")
                .setAuth(obj -> {
                    if (!StpUtil.isLogin()) {
                        SaRouter.back(JSONUtil.toJsonStr(Result.fail(HttpStatusEnum.UNAUTHORIZED, null)));
                    }
                });
    }
}
