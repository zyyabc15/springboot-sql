package com.oo.springboot.mysql.jpa;

import com.oo.springboot.mysql.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface UserJPA extends JpaRepository<UserEntity, Integer> {

    @Query(value = "select * from t_user where t_age >:age and t_name like %:name%", nativeQuery = true)
    public List<UserEntity> nativeQuery(@Param("age") int age, @Param("name") String name);

    @Query(value = "select * from t_user where t_age >?1 and t_name like %?2%", nativeQuery = true)
    public List<UserEntity> nativeQuery1(int age, String name);

    //此处应用#{#entityName} 需在model实体类应用@Entity(name = "t_user")注解 方可替换为表名
    @Query(value = "select * from #{#entityName} where t_name = ?1", nativeQuery = true)
    List<UserEntity> findByName(String name);

    @Transactional
    @Modifying
    @Query(value="delete from t_user where t_name =?1",nativeQuery = true)
    public  void deleteBy(String name);
}
