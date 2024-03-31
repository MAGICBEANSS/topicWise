package org.dsa.topics.test;

import java.util.Arrays;

public class KPSack {
    private static int[][] dp;
    public static void main(String[] args) {
        int[] wt = {3,2,1,5};
        int[] price = {1,5,2,3};
        int target = 6;
        dp = new int[wt.length+1][target+1];
        init(dp);
        int z = findMaxMemoization(wt,price,0,target,0);
        System.out.println(z);
    }

     static void init(int[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i],-1);
        }
    }


    private static int findMaxMemoization(int[] wt, int[] price, int i, int target, int priceTillNow) {
        if(target==0) {
            return priceTillNow;
        }
        if(i>=wt.length || target<0) {
            return 0;
        }
        if(dp[i][target]!=-1) {
            return dp[i][target];
        }

        dp[i][target] =  Math.max(
                findMax(wt,price,i+1,target,priceTillNow),
                findMax(wt,price,i+1,target-wt[i],priceTillNow+price[i])
        );
        return dp[i][target];
    }

    private static int findMax(int[] wt, int[] price, int i, int target, int priceTillNow) {
        if(target==0) {
            return priceTillNow;
        }
        if(i>=wt.length || target<0) {
            return 0;
        }

        return Math.max(
                findMax(wt,price,i+1,target,priceTillNow),
                findMax(wt,price,i+1,target-wt[i],priceTillNow+price[i])
        );
    }
}
