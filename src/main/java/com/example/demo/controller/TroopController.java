package com.example.demo.controller;

import com.example.demo.model.Troop;
import com.example.demo.service.TroopServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class TroopController {

    private final TroopServiceImpl troopService;

    @GetMapping(value = "/troops/amount/{amount}")
    public List<Troop> getTroop(@PathVariable Long amount) {
        return troopService.get(amount);
    }
}
