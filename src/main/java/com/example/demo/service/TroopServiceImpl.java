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



    public List<Troop> get(Long amount) {

        //creating ret List of troops

        List<Troop> retTroop = new ArrayList<>();

        Troop spearmen = new Spearmen();
        Troop swordsmen = new Swordsmen();
        Troop archer = new Archer();

        retTroop.add(spearmen);
        retTroop.add(swordsmen);
        retTroop.add(archer);

        //generating and setting amounts

        Integer[] troopsAmount = troopsAmountGenerate(amount);

        spearmen.setAmount(troopsAmount[0]);
        swordsmen.setAmount(troopsAmount[1]);
        archer.setAmount(troopsAmount[2]);

        //setting types
        spearmen.setTroopType("spearmen");
        swordsmen.setTroopType("swordsmen");
        archer.setTroopType("archer");

        return retTroop;
    }

    private Integer[] troopsAmountGenerate(Long amount) {

        Random random = new Random();
        Integer[] troopsAmount = new Integer[TROOPS_TYPES_SIZE];
        int totalAmountCache = 0;

        for (int i = 0; i < TROOPS_TYPES_SIZE; i++) {

            if (i < TROOPS_TYPES_SIZE - 1) {
                int troopAmount = random.nextInt(amount.intValue() - totalAmountCache) + 1;
                totalAmountCache += troopAmount;
                troopsAmount[i] = troopAmount;
            } else {

                //rest for the last one in array
                troopsAmount[i] = amount.intValue() - totalAmountCache;
            }
        }
        return troopsAmount;
    }
}
