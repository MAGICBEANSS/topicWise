package org.dsa.topics.searching.SELF;

import java.util.Arrays;

public class MinimumBouqets {
    //https://takeuforward.org/arrays/minimum-days-to-make-m-bouquets/

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
