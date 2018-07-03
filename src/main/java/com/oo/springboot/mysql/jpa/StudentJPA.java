package com.oo.springboot.mysql.jpa;

import com.oo.springboot.mysql.model.StudentEntity;

import org.springframework.data.jpa.repository.JpaRepository;



public interface StudentJPA extends
        JpaRepository<StudentEntity,Integer>{

}
