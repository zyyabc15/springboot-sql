package com.oo.springboot.mysql;

import com.oo.springboot.mysql.jpa.StudentJPA;
import com.oo.springboot.mysql.model.StudentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/student")
public class StudentController {

    @Autowired
    private StudentJPA studentJpa;


    /**
     * @Author zhaoyuanyuan
     * @Description 查询方法
     * @Date 17:07 2018/6/29
     * @Param []
     * @return java.util.List<com.oo.springboot.mysql.model.StudentEntity>
     *     http://localhost:8080/student/all
     **/
    @RequestMapping(value="/all")
    public List<StudentEntity> selectAll(){
        return studentJpa.findAll();
    }


    /**
     * @Author zhaoyuanyuan
     * @Description 保存对象
     * @Date 13:45 2018/7/2
     * @Param [entity]
     * @return com.oo.springboot.mysql.model.StudentEntity
     * http://localhost:8080/student/save?name=oo&score_avg=23&score_sum=45&age=4
     **/
    @RequestMapping(value="/save")
    public StudentEntity save(StudentEntity entity){

        return studentJpa.save(new StudentEntity("o1oo","34","45",22));
    }
}
