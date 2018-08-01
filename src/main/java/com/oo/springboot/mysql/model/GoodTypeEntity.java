package com.oo.springboot.mysql.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @ClassName GoodTypeEntity
 * @Description TODO
 * @Author zhaoyuanyuan-ds
 * @Date 2018/7/31 17:52
 * @Version 1.0
 **/
@Entity
@Table(name = "good_types")
public class GoodTypeEntity implements Serializable
{
    @Id
    @GeneratedValue
    @Column(name = "tgt_id")
    private Long id;

    @Column(name = "tgt_name")
    private String name;

    @Column(name = "tgt_is_show")
    private int isShow;

    @Column(name = "tgt_order")
    private int order;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIsShow() {
        return isShow;
    }

    public void setIsShow(int isShow) {
        this.isShow = isShow;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }
}
