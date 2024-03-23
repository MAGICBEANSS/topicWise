package org.dsa.topics.DP;

import java.util.Arrays;

public class CountOfSubsetsWithEqualsSum {
    public static void main(String[] args) {
        int[] arr = {1,5,11,5};
        int totalSum = Arrays.stream(arr).sum();
        int halfSum = totalSum/2;
        int[][] dp = DPFiller.filler(arr.length+1,halfSum+1,0,1,-1);
        System.out.println(solveUsingDP(dp,arr));
    }

    private static int solveUsingDP(int[][] dp, int[] arr) {
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] = dp[i-1][j];
                if(arr[i-1]<=j) {
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-arr[i-1]];
                }
                int z =2;
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }
}
