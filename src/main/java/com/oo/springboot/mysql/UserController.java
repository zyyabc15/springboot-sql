package com.oo.springboot.mysql;

import com.oo.springboot.mysql.jpa.UserJPA;
import com.oo.springboot.mysql.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/user")
public class UserController {

    @Autowired
    private UserJPA userJPA;


    /**
     * @Author zhaoyuanyuan
     * @Description 查询方法
     * @Date 17:07 2018/6/29
     * @Param []
     * @return java.util.List<com.oo.springboot.mysql.model.StudentEntity>
     *     http://localhost:8080/user/all
     **/
    @RequestMapping(value="/all")
    public List<UserEntity> selectAll(){
        return userJPA.findAll();
    }


    /**
     * @Author zhaoyuanyuan
     * @Description 保存对象
     * @Date 13:45 2018/7/2
     * @Param [entity]
     * @return com.oo.springboot.mysql.model.StudentEntity
     * http://localhost:8080/user/save?name=oo&address=23&age
     **/
    @RequestMapping(value="/save")
    public UserEntity save(UserEntity entity){

        return userJPA.save(entity);
    }
}
