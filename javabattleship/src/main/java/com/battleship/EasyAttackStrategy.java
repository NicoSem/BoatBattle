package com.battleship;

import java.util.ArrayList;
import java.util.List;

public class EasyAttackStrategy implements AttackStrategy {
    private List<String> cellsToAttack;

    public EasyAttackStrategy() {
        cellsToAttack = new ArrayList<String>();
        for(int i = 0; i < 10; i ++) {
            for (int j = 0; j < 10; j++) {
                cellsToAttack.add(String.valueOf(i) + String.valueOf(j));
            }
        }
    }

    @Override
    public String getCoordinates(String attackResult) {
        int randIndex = (int) (Math.random() * cellsToAttack.size());
        return cellsToAttack.remove(randIndex);
    }
}
