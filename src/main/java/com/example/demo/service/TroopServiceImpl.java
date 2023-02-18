package com.example.demo.service;

import com.example.demo.model.Archer;
import com.example.demo.model.Spearmen;
import com.example.demo.model.Swordsmen;
import com.example.demo.model.Troop;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class TroopServiceImpl {

    private static final int TROOPS_TYPES_SIZE = 3;
    private final Random random = new Random();


    public List<Troop> get(Integer amount) {

        List<Troop> retTroop = new ArrayList<>();

        for (int i = 0; i < TROOPS_TYPES_SIZE; i++) {
            Troop troop = null;
            switch (i) {
                case 0:
                    troop = new Spearmen();
                    break;
                case 1:
                    troop = new Swordsmen();
                    break;
                case 2:
                    troop = new Archer();
                    break;
            }
            retTroop.add(troop);
        }

        Integer[] troopsAmount = troopsAmountGenerate(amount);

        retTroop.get(0).setAmount(troopsAmount[0]);
        retTroop.get(1).setAmount(troopsAmount[1]);
        retTroop.get(2).setAmount(troopsAmount[2]);

        return retTroop;

    }

    private Integer[] troopsAmountGenerate(Integer amount) {

        int maxAmountPerType = (amount + TROOPS_TYPES_SIZE - 1) / TROOPS_TYPES_SIZE;

        Integer[] troopsAmount = new Integer[TROOPS_TYPES_SIZE];
        int totalAmount = 0;

        for (int i = 0; i < TROOPS_TYPES_SIZE; i++) {

            if (i < TROOPS_TYPES_SIZE - 1) {
                int maxAmount = Math.min(maxAmountPerType, amount - totalAmount - (TROOPS_TYPES_SIZE - i - 1));
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
