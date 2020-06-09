package com.zhuqc.framework.common;

import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * 分页查询 统一返回结果
 *
 * @author Zhu.Qianchang
 * @date 2020-05-20
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class QueryResult<T> {

    /**
     * 总条数
     */
    private Long total;

    /**
     * 返回结果集
     */
    private List<T> items;

    public QueryResult(IPage<T> page) {
        this.total = page.getTotal();
        this.items = page.getRecords();
    }
}
