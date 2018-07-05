package com.oo.springboot.mysql.test;

import com.oo.springboot.mysql.jpa.UserJPA;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * @ClassName UserTest
 * @Description TODO
 * @Author zhaoyuanyuan-ds
 * @Date 2018/7/3 18:27
 * @Version 1.0
 **/
@RunWith(SpringRunner.class)
@SpringBootTest

public class UserTest {

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
    private UserJPA userJPA;

    @Before
    public void before() {
        //获取mockmvc对象实例
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testAll() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/user/all"))
                .andReturn();
        int status = mvcResult.getResponse().getStatus();
        String responseString = mvcResult.getResponse().getContentAsString();
        Assert.assertEquals("请求错误", 200, status);
        Assert.assertEquals("条数不对",mvcResult.getResponse().getContentLength());
//        Assert.assertEquals("返回结果不一致", "this is index pageadmin", responseString); // 8

    }
    @Test
    public void testInsert() throws Exception{
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/user/save")
                .param("name","12oo")
                .param("address","address")
                .param("age","28")).andReturn();
        Assert.assertNotNull(mvcResult.getResponse().getContentAsString());
        System.out.println(mvcResult.getResponse().getContentAsString());
    }
    @Test
    public void testAge() throws Exception{
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/user/byAge")
        .param("age","20")
        .param("name","12")).andReturn();
//        Assert.assertNotNull(mvcResult.getResponse().getContentAsString());
        System.out.println(mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void byName() throws Exception{
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/user/byName")
                .param("name","12")).andReturn();
//        Assert.assertNotNull(mvcResult.getResponse().getContentAsString());
        System.out.println(mvcResult.getResponse().getContentAsString());
    }
    @Test
    public void testDelByName() throws Exception{
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/user/delByName")
                .param("name","oo1")).andReturn();
//        Assert.assertNotNull(mvcResult.getResponse().getContentAsString());
        System.out.println(mvcResult.getResponse().getContentAsString());
    }
    @Test
    public void testCutPage() throws Exception{
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/user/cutPage")
                ).andReturn();
//        Assert.assertNotNull(mvcResult.getResponse().getContentAsString());
        System.out.println(mvcResult.getResponse().getContentAsString());
    }
}
