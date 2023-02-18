package com.example.demo.model;

import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class Spearmen extends Troop {
    private final String troopType = "Spearmen";
}
