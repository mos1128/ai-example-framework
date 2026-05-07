package com.example.common.base;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 通用分页查询参数
 *
 * @author mos
 */
@Data
@Accessors(chain = true)
public class PageQuery {

    @Schema(description = "页码", defaultValue = "1")
    @Min(value = 1, message = "页码不能小于1")
    private Integer pageNo = 1;

    @Schema(description = "每页条数", defaultValue = "10")
    @Min(value = 1, message = "每页条数不能小于1")
    private Integer pageSize = 10;

    @Schema(description = "排序字段+规则，多个用英文逗号分隔", example = "id asc,num desc")
    private String order;
}
