package com.example.demo.service;

import com.example.demo.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.HashMap;
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
     * This method generates an array of troop amounts for a given total amount and a specified number of troop types.
     * @param amount represents the total number of troops to generate
     * @return Array of integers representing the number of troops for each troop type
     *
     * The first step to calculate the maximum number of troops per type, which is maxAmountPerType.
     * Next, create an array of typesAmount integers called troopsAmount to store the final number of troops for
     * each type.
     * The variable totalAmount will keep track of the total number of troops was assigned.
     * The loop iterates over each troop type. For each type, method calculates the max number of troops
     * that can be assigned. The Math.min function is used to ensure that the maximum amount does not exceed
     * maxAmountPerType.
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
