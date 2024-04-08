package org.dsa.topics.mcm;

import java.util.HashMap;
import java.util.Map;

public class EggDropProblem {
    private static Map<String,Integer> hm = new HashMap<>();
    public static void main(String[] args) {
        int floor = 10;
        int eggs = 3;
        System.out.println(solveEggDrop(floor,eggs));
    }

    private static int solveEggDrop(int floor, int eggs) {
        hm = new HashMap<>();
        return solveProblem(floor,eggs);

    }

    private static int solveProblem(int floor, int eggs) {
        if(floor<=0) return 0;
        if(eggs<=0) return Integer.MAX_VALUE;

        for (int k = 1; k < floor; k+=eggs) {

        }
        return -1;
    }


}
