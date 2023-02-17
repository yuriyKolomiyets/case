package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Troop {
    private Integer amount;
    private String troopType;
}
