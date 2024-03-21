package org.dsa.topics.searching.SELF;

import java.util.Arrays;

public class MinimumBouqets {
    //https://takeuforward.org/arrays/minimum-days-to-make-m-bouquets/


    /**
     * Just like other problems like Koko Eating bananas our intuition is to find a range amd
     * try using possible no out of the range to find the optimum solution
     * lowBound = 1;
     * At worst case , we have to wait for max no of days for all flowers to boom and then
     * check if we can make m bouquets
     * it may or may not  be a solution even after waiting max no of days
     *
     * Say we have array blooming like [2,3,4,8,8,2] m=2, k=4
     *
     * So here at least at the 8th day we will have all flowers blossomed up
     * If we cannot make m bouqets of k adjacent one for this we may never make it .
     *
     * So we keep high_bound as max
     *
     *Now if there is a solution at max no of days , our task is to minimise this max to as low as possible
     * So we do a binary search in the range low bound - high bound i.e. 1....max
     * And try whether we can make required bouquets at that {mid} day or not
     * To check this we use a method {@link #isMakePossible isMakePossible}
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] flowersBoomDay = {7,7,7,7,12,7,7};
     //   int[] flowersBoomDay = {7,7,7,7,13, 11, 12, 7};
        int m = 2;
        int k =3;
        int findFlowerday = findBouqets(flowersBoomDay,m,k);
        System.out.println(findFlowerday);
    }

    private static int findBouqets(int[] flowersBoomDay, int m, int k) {
        int high = Integer.MIN_VALUE;
        for (int num : flowersBoomDay) {
            high = Math.max(high, num);
        }
        if((m*k)>flowersBoomDay.length) return -1;
        int sol = -1;
        int low = 1;
        int mid = -1;
        while (low<=high) {
            mid = (low+high)/2;
            if(isMakePossible(flowersBoomDay,m,k,mid)) {
                sol = mid;
                high=mid-1;
            }
            else {
                low=mid+1;
            }
        }

        return sol;
    }

    private static boolean isMakePossible(int[] flowersBloomDay,int m ,int k , int days){
        int len = flowersBloomDay.length;
        int countContinuous = 0;
        for (int i = 0; i < len && m>0; i++) {
            if(flowersBloomDay[i]<=days) {
                countContinuous++;
                if(countContinuous>=k) {
                    countContinuous=countContinuous-k;
                    m--;
                }
            }
            else {
                countContinuous = 0;
            }
        }
        return m<=0;
    }
}
