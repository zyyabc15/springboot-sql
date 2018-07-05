package com.oo.springboot.mysql;

import com.oo.springboot.mysql.jpa.UserJPA;
import com.oo.springboot.mysql.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.html.parser.Entity;
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
    /**
     * @Author zhaoyuanyuan
     * @Description //按年龄查询大于age的用户
     * @Date 14:30 2018/7/4
     * @Param [age]
     * @return java.util.List<com.oo.springboot.mysql.model.UserEntity>
     **/
    @RequestMapping(value="/byAge")
    public List<UserEntity> getByAge(Integer age,String name){
        return userJPA.nativeQuery1(age,name);
    }
    /**
     * @Author zhaoyuanyuan
     * @Description //按名字查询
     * @Date 14:30 2018/7/4
     * @Param [age]
     * @return java.util.List<com.oo.springboot.mysql.model.UserEntity>
     **/
    @RequestMapping(value="/byName")
    public List<UserEntity> getByName(String name){
        return userJPA.findByName(name);
    }

    @RequestMapping(value="/delByName")
    public void delByName(String name){
       userJPA.deleteBy(name);
    }
    /**
     * @Author zhaoyuanyuan
     * @Description //分页查询排序
     * @Date 11:21 2018/7/5
     * @Param [name]
     * @return java.util.List<com.oo.springboot.mysql.model.UserEntity>
     **/
    @RequestMapping(value="/cutPage")
    public List<UserEntity> cutPage(String name){
        Sort.Direction sortDirection= Sort.Direction.ASC.toString().equalsIgnoreCase("asc")? Sort.Direction.ASC: Sort.Direction.DESC;
        Sort sort = new Sort(sortDirection,"age");
      return   userJPA.findAll(new PageRequest(0,3,sort)).getContent();
    }
}
