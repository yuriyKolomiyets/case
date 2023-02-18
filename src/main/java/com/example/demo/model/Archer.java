package com.example.demo.model;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class Archer extends Troop {

    private final String troopType = "Archer";
}
