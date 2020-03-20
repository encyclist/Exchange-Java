package com.erning.exchange.dao;

import com.erning.exchange.entity.Exchange;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * @author :二宁
 * @date :Created in 2019/11/11 16:24
 */
@Repository
@Component
public interface BaseDao {
    Exchange getWithCode(@Param("code") String code);

    void insert(Exchange exchange);

    void update(Exchange exchange);
}
