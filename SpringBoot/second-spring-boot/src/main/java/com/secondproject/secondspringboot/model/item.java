package com.secondproject.secondspringboot.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tbl_item")
public class item {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "pic")
    private String pic;

    @Column(name = "price")
    private float price;

    @Column(name = "created_date")
    private Date createdDate;

    @Column(name = "status")
    private String status;

    public item() {}

    public item(String id, String name, String pic, float price, Date createdDate, String status) {
        this.id = id;
        this.name = name;
        this.pic = pic;
        this.price = price;
        this.createdDate = createdDate;
        this.status = status;
    }

    

}
