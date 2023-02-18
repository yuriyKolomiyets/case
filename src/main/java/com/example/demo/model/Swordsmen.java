package com.example.demo.model;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class Swordsmen extends Troop {
    private final String troopType = "Swordsmen";
}
