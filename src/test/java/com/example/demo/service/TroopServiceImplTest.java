package com.example.demo.service;

import com.example.demo.model.Army;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.demo.model.Troop;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class TroopServiceImplTest {

    @InjectMocks
    private TroopServiceImpl troopService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void get() {
        Integer amount = 10;
        Army army = troopService.get(amount);
        Map<Troop, Integer> army1 = army.getArmy();

        // check that all troops.getAmount will be not equals to 0

        assertTrue(army1.entrySet().stream().allMatch(entry -> entry.getValue() != 0));

        // check that sum of all troops.getAmount will be equals to amount

        Integer totalAmount = army1.values().stream()
                .mapToInt(Integer::intValue)
                .sum();
        assertEquals(amount, totalAmount);
    }
}