package com.secondproject.secondspringboot.dataTransferObject;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class categoryDto {
    private String id;
    private String name;

    public categoryDto() {}

    public categoryDto(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
