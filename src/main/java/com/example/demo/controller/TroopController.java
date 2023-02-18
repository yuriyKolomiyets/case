package com.example.demo.controller;

import com.example.demo.model.Army;
import com.example.demo.model.Type;
import com.example.demo.service.TroopServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class TroopController {

    private final TroopServiceImpl troopService;


    @GetMapping(value = "/troops/amount/{amount}")
    public Army getArmy(@PathVariable("amount") Integer amount) {
        if(amount < Type.values().length){
            throw new IllegalArgumentException("amount must be more than 3");
        }
        return troopService.get(amount);
    }

}
