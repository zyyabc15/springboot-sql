package com.oo.springboot.mysql.model;

import javax.persistence.*;

@Entity
@Table(name="student")


public class StudentEntity {
    @Id
    //strategy 配置为必须 避免数据库中已有数据时 发生主键冲突异常
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name ;
    private String score_avg;
    private String score_sum;
    private Integer age;

    public StudentEntity(String name, String score_avg, String score_sum, Integer age) {
        this.name = name;
        this.score_avg = score_avg;
        this.score_sum = score_sum;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScore_avg() {
        return score_avg;
    }

    public void setScore_avg(String score_avg) {
        this.score_avg = score_avg;
    }

    public String getScore_sum() {
        return score_sum;
    }

    public void setScore_sum(String score_sum) {
        this.score_sum = score_sum;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
