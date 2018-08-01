package com.oo.springboot.mysql.test;

import com.oo.springboot.mysql.jpa.GoodJPA;
import com.oo.springboot.mysql.model.QGoodEntity;
import com.oo.springboot.mysql.model.QGoodTypeEntity;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.Predicate;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

/**
 * @ClassName
 * @Description TODO
 * @Author zhaoyuanyuan-ds
 * @Date 2018/7/31 18:35
 * @Version 1.0
 **/

@RunWith(SpringRunner.class)
@SpringBootTest
public class GoodTest {
    /**
     * 模拟mvc测试对象
     */
    private MockMvc mockMvc;

    /**
     * web项目上下文
     */
    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private GoodJPA goodJPA;



}
