package com.oo.springboot.mysql;

import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @ClassName
 * @Description TODO
 * @Author zhaoyuanyuan-ds
 * @Date 2018/8/1 11:06
 * @Version 1.0
 **/
public class Inquirer {
    //查询条件集合
    private List<BooleanExpression> expressions;
    public Inquirer(){
        this.expressions = new ArrayList<>();
    }
    /**
     * @Author zhaoyuanyuan
     * @Description 添加查询条件到Query内的查询集合内
     * @Date 11:09 2018/8/1
     * @Param [expression] 查询条件继承BooleanExpression抽象对象的具体实体对象querydsl已经封装
     * @return com.oo.springboot.mysql.Inquirer
     **/
    public Inquirer putExpression(BooleanExpression expression){
        //添加到条件集合
        expressions.add(expression);
        return this;
    }

    public Predicate  buidleQuery(){
        //第一个查询条件对象
        BooleanExpression be = null;
        //遍历所有查询条件，以第一个开始and
        for(int i=0;i<expressions.size();i++){
            if(i==0){
                be = expressions.get(i);
            }else {
                be = be.and(expressions.get(i));
            }
        }
        return be;
    }
    public <T> List<T> iteratorToList(Iterable<T> iterable){
        List<T> returnList = new ArrayList<>();
        Iterator<T> iterator = iterable.iterator();
        while (iterator.hasNext()){
            returnList.add(iterator.next());
        }
        return returnList;
    }

}
