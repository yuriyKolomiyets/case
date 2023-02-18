package com.example.demo.service;

import com.example.demo.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class TroopServiceImpl {

    private final Random random = new Random();
    int typesAmount = Type.values().length;



    public Army get(Integer amount) {

        HashMap<Troop, Integer> armyMap = new HashMap<>();
        Army retArmy = new Army(armyMap);
        Integer[] troopsAmount = troopsAmountGenerate(amount);

        for (int i = 0; i < typesAmount; i++) {
            armyMap.put(new Troop(Type.values()[i]),troopsAmount[i]);

        }

        return retArmy;

    }

    /**
     *
     * @param amount
     * @return Array of amounts of troops for each type
     */

    private Integer[] troopsAmountGenerate(Integer amount) {

        int maxAmountPerType = (amount + typesAmount - 1) / typesAmount;

        Integer[] troopsAmount = new Integer[typesAmount];

        int totalAmount = 0;

        for (int i = 0; i < typesAmount; i++) {

            if (i < typesAmount - 1) {
                int maxAmount = Math.min(maxAmountPerType, amount - totalAmount - (typesAmount - i - 1));
                int troopAmount = random.nextInt(maxAmount) + 1;
                troopsAmount[i] = troopAmount;
                totalAmount += troopAmount;
            } else {
                troopsAmount[i] = amount - totalAmount;
            }
        }
        return troopsAmount;
    }
}
