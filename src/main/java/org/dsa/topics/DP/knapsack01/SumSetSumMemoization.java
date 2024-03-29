package org.dsa.topics.DP.knapsack01;

import java.util.Objects;

public class SumSetSumMemoization {
    static Boolean[][] dp;
    public static void main(String[] args) {
        int[] set = {3, 34, 4, 4, 54};
        int sum = 7;
        dp = new Boolean[set.length + 1][sum + 1];
        System.out.println(solveUsingMemoization(set,0,sum));
        int z = 0;
    }

    private void init(Boolean[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
              //  dp[i][j]  =
            }
        }
    }

    private static boolean solveUsingMemoization(int[] arr, int i,int toGet){
        if(toGet==0){
            return true;
        }
        if(i>=arr.length) return false;
        if(Objects.nonNull(dp[i][toGet])) {
            return dp[i][toGet];
        }
        if(toGet<arr[i]) {
            dp[i][toGet] =  solveUsingMemoization(arr,i+1,toGet);
        }
        else {
            dp[i][toGet] =  solveUsingMemoization(arr,i+1,toGet) || solveUsingMemoization(arr,i+1,toGet-arr[i]);
        }
        return dp[i][toGet];
    }

    private static boolean solveUsingRecursion(int[] arr, int i,int toGet){
        if(toGet==0){
            return true;
        }
        if(i>=arr.length) return false;
        if(toGet<arr[i]) {
            return solveUsingRecursion(arr,i+1,toGet);
        }
        else {
            return solveUsingRecursion(arr,i+1,toGet) || solveUsingRecursion(arr,i+1,toGet-arr[i]);
        }
    }


}
