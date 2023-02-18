package com.example.demo.controller;

import com.example.demo.model.Troop;
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
@Validated
public class TroopController {

    private final TroopServiceImpl troopService;
    private static final int TROOPS_TYPES_SIZE = 3;


    @GetMapping(value = "/troops/amount/{amount}")
    public List<Troop> getTroop(@PathVariable("amount") @Min(value = 3, message = "Amount must be more than 3") Integer amount) {
        log.info("Validating amount: {}", amount);
        return troopService.get(amount);
    }

}
