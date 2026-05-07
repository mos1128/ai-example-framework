package com.example.common.utils;

import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.core.util.StringUtil;
import org.springframework.util.StringUtils;

import java.util.Arrays;

/**
 * 分页工具类
 *
 * @author mos
 */
public class PageUtil {

    /**
     * 为 MyBatis-Flex QueryWrapper 追加排序条件。
     *
     * @param queryWrapper 要修改的 QueryWrapper 对象
     * @param order        排序字符串（例：id asc,num desc）
     */
    public static void addOrder(QueryWrapper queryWrapper, String order) {
        if (queryWrapper == null || !StringUtils.hasText(order)) {
            return;
        }

        Arrays.stream(order.split(","))
                .map(String::trim)
                .filter(StringUtil::hasText)
                .map(s -> s.split("\\s+"))
                .filter(arr -> arr.length == 2)
                .filter(arr -> "asc".equalsIgnoreCase(arr[1]) || "desc".equalsIgnoreCase(arr[1]))
                .forEach(arr -> {
                    String column = StringUtil.camelToUnderline(arr[0]);
                    boolean asc = "asc".equalsIgnoreCase(arr[1]);
                    queryWrapper.orderBy(new QueryColumn(column), asc);
                });
    }
}
