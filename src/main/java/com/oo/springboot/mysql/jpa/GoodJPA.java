package com.oo.springboot.mysql.jpa;

import com.oo.springboot.mysql.model.GoodEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

/**
 * @ClassName
 * @Description TODO
 * @Author zhaoyuanyuan-ds
 * @Date 2018/7/31 17:58
 * @Version 1.0
 **/
public interface GoodJPA extends JpaRepository<GoodEntity,Long>,QuerydslPredicateExecutor<GoodEntity>{

}
