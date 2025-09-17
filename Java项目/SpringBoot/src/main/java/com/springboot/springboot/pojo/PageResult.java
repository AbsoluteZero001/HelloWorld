package com.springboot.springboot.pojo;

import com.github.pagehelper.Page;
import jakarta.validation.constraints.NotNull;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public final class PageResult<T> {
    private final Integer pageNum;
    private final Integer pageSize;
    private final Long total;   // ← 改成 Long，兼容 PageHelper 的 total
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
        return new PageResult<>(page.getPageNum(),
                page.getPageSize(),
                page.getTotal(),
                page.getResult());
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
}
