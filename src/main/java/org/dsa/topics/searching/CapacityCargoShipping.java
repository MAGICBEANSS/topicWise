package org.dsa.topics.searching;

import java.util.Arrays;

public class CapacityCargoShipping {

    //https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/description/

    public static void main(String[] args) {
     //   int[]  weights = {1,2,3,4,5,6,7,8,9,10};
        int[]  weights = {5, 4 ,5, 2, 3, 4, 5, 6};
        int days = 5;
        int z = shipWithinDays(weights,days);
        System.out.println(z);


    }

    public static int shipWithinDays(int[] weights, int days) {
            int maxWeight = Arrays.stream(weights).reduce(0,(a,b)->a>b? a:b);
            int allWeights = Arrays.stream(weights).sum();
            int capacity = findAnswer(maxWeight,allWeights,weights,days);
            return capacity;
    }

    private static int  findAnswer(int maxWeight, int allWeights, int[] weights, int days) {
        int high = allWeights;
        int low = maxWeight;
        int sol = allWeights;
        while (low<=high) {
            int mid = (low+high)/2;
            int cansolve =  cansolve(mid,weights,days);
            if(cansolve==0) {
                sol = Math.min(sol,mid);
                high = mid-1;
            }
            else if(cansolve>0){
                high = mid-1;
            }
            else if(cansolve<0){
                low = mid+1;
            }
        }
        return low;
    }

    private static int cansolve(int totry, int[] weights, int days) {
            int cut = totry;
            int cdays = 1;
            int load =0;
        for (int i = 0; i < weights.length; i++) {
            if(weights[i]+load>totry) {
                cdays++;
                load = weights[i];
            }
            else {
                load=load+weights[i];
            }
            
        }
           if(days>cdays) return 1;
           if(days<cdays) return -1;
           else return 0;
    }
}
