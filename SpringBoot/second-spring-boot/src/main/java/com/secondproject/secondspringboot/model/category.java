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
@Table(name = "tbl_category")
public class category {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "created_date")
    private Date createdDate;

    public category() {}

    public category(String id, String name, Date createdDate) {
        this.id = id;
        this.name = name;
        this.createdDate = createdDate;
    }

    
}
