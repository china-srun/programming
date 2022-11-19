package com.secondproject.secondspringboot.dataTransferObject;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class itemDto {
    private String id;
    private String name;
    private String pic;
    private float price;

    public itemDto() {}

    public itemDto(String id, String name, String pic, float price) {
        this.id = id;
        this.name = name;
        this.pic = pic;
        this.price = price;
    }

    
}
