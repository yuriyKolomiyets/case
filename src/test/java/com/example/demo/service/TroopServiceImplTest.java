package com.example.demo.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.demo.model.Troop;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.util.List;

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

        int amount = 5;
        List<Troop> troops = troopService.get(amount);
        int totalAmount = troops.stream().mapToInt(Troop::getAmount).sum();

        // check that all troops.getAmount will be not equals to 0
        assertEquals(troops.size(), troops.stream().filter(troop -> troop.getAmount() != 0).count());

        // check that sum of all troops.getAmount will be equals to amount
        assertEquals(amount, totalAmount);
    }
}