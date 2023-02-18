package com.example.demo.controller;

import com.example.demo.model.Troop;
import com.example.demo.service.TroopServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@RequiredArgsConstructor
@RestController
@Validated
public class TroopController {

    private final TroopServiceImpl troopService;
    private static final int TROOPS_TYPES_SIZE = 3;


    @GetMapping(value = "/troops/amount/{amount}")
    public List<Troop> getTroop(@PathVariable("amount")
                                @Valid @Min(value = TROOPS_TYPES_SIZE,
                                message = "amount must be more than 3") Integer amount) {

        return troopService.get(amount);
    }
}
