package com.springboot.springboot.pojo;

import com.github.pagehelper.Page;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Schema(description = "分页结果")
public final class PageResult<T> {

    @Schema(description = "当前页码")
    private final Integer pageNum;

    @Schema(description = "每页记录数")
    private final Integer pageSize;

    @Schema(description = "总记录数")
    private final Long total;

    @Schema(description = "分页数据")
    private final List<T> list;

    private PageResult(@NotNull Integer pageNum,
                       @NotNull Integer pageSize,
                       @NotNull Long total,
                       @NotNull List<T> list) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.total = total;
        this.list = list;
    }

    /**
     * 手动构造 PageResult
     */
    public static <T> PageResult<T> restPage(@NotNull Integer pageNum,
                                             @NotNull Integer pageSize,
                                             @NotNull Long total,
                                             @NotNull List<T> list) {
        return new PageResult<>(pageNum, pageSize, total,
                Optional.ofNullable(list).orElse(Collections.emptyList()));
    }

    /**
     * 将 PageHelper 的分页结果转换为 PageResult 对象
     */
    public static <T> PageResult<T> restPage(@NotNull Page<T> page) {
        List<T> list = new ArrayList<>(page.getResult() != null ? page.getResult() : Collections.emptyList());
        return new PageResult<>(page.getPageNum(),
                page.getPageSize(),
                page.getTotal(),
                list);
    }

    // getter
    public Integer getPageNum() {
        return pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public Long getTotal() {
        return total;
    }

    public List<T> getList() {
        return list;
    }

    @Override
    public String toString() {
        return "PageResult{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", total=" + total +
                ", list=" + list +
                '}';
    }
}
