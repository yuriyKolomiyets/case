package com.example.demo.controller;

import com.example.demo.model.Army;
import com.example.demo.model.Troop;
import com.example.demo.model.Type;
import com.example.demo.service.TroopServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Min;
import java.util.List;

@Slf4j
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
