package com.oo.springboot.mysql.jpa;

import com.oo.springboot.mysql.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;



public interface UserJPA extends JpaRepository<UserEntity, Integer>{
}
