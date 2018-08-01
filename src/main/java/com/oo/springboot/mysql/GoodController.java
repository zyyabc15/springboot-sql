package com.oo.springboot.mysql;

import com.oo.springboot.mysql.jpa.GoodJPA;
import com.oo.springboot.mysql.model.GoodEntity;
import com.oo.springboot.mysql.model.QGoodEntity;
import com.oo.springboot.mysql.model.QGoodTypeEntity;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @ClassName QueryController
 * @Description TODO
 * @Author zhaoyuanyuan-ds
 * @Date 2018/7/31 17:56
 * @Version 1.0
 **/
@RestController
@RequestMapping(value="/good")
public class GoodController {
    @Autowired
    private GoodJPA goodJPA;

    //注入EntityManager
    @PersistenceContext
    private EntityManager entityManager;

    @RequestMapping(value = "/query")
    public List<GoodEntity> list(){
        // 查询实体
        QGoodEntity _good = QGoodEntity.goodEntity;
        // 构建JPA查询对象
        JPAQuery<GoodEntity> jpaQuery = new JPAQuery<>(entityManager);
        return jpaQuery.select(_good).from(_good).where(_good.type.id.eq(Long.valueOf("1"))).fetch();
    }
    /**
     * @Author zhaoyuanyuan
     * @Description springData jpa 整合querydsl完成查询
     * @Date 10:58 2018/8/1
     * @Param
     * @return
     **/
    @RequestMapping(value="/join")
    public List<GoodEntity> join (){
//        //querydsl查询实体
//        QGoodEntity _good = QGoodEntity.goodEntity;
//        //查询条件
//        BooleanExpression expression = _good.type.id.eq(Long.valueOf("1"));
//        //执行查询
//        Iterator<GoodEntity> iterator = goodJPA.findAll(expression).iterator();
//        List<GoodEntity> goods = new ArrayList<>();
//        //转成list
//        while (iterator.hasNext()){
//            goods.add(iterator.next());
//        }
//        return goods;


        QGoodEntity _good = QGoodEntity.goodEntity;
        Inquirer inquirer = new Inquirer();
        //添加查询条件
        inquirer.putExpression(_good.type.id.eq(Long.valueOf("1")));
        //返回查询结果
        return inquirer.iteratorToList(goodJPA.findAll(inquirer.buidleQuery()));
    }
    /**
     * @Author zhaoyuanyuan
     * @Description 单表分页查询
     * @Date 14:13 2018/8/1
     * @Param []
     * @return java.util.List<com.oo.springboot.mysql.model.GoodEntity>
     **/
    @RequestMapping(value = "/singleTablePageSort")
    public List<GoodEntity> singleTablePageSort(){
        QGoodEntity _good = QGoodEntity.goodEntity;
        Predicate predicate = _good.type.id.eq(Long.valueOf("2"));
        //分页排序
        Sort sort = new Sort(new Sort.Order(Sort.Direction.ASC,"order"));
        PageRequest pageRequest = new PageRequest(1,2,sort);
        Page<GoodEntity> goodEntities = goodJPA.findAll(predicate,pageRequest);
        Inquirer inquirer = new Inquirer();
        return inquirer.iteratorToList(goodEntities);
    }


}
