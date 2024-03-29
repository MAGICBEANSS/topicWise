package org.dsa.topics.DP.knapsack01.trrr;

import java.util.Arrays;

public class TargetSum {

    public static void main(String[] args) {
        int[] arr = {0,0,0,0,0,0,0,0,1};
        int target  = 1;
        System.out.println(findTargetSumWays(arr,target));
    }

    public static int findTargetSumWays(int[] arr, int target) {

        int totalSum = Arrays.stream(arr).sum();
        int s1 = (totalSum + target) % 2 == 0 ? (totalSum + target) / 2 : 0;
        if (totalSum < target || s1 == 0) return 0;
        int[][] dp = new int[arr.length+1][s1+1];
        dp[0][0] = 1;
          //  int[][] dp = DPFiller.filler(arr.length+1,s1+1,0,1,0);
            for (int i = 1; i < dp.length; i++) {
                for (int j = 0; j < dp[0].length; j++) {
                    dp[i][j] = dp[i-1][j];
                    if(j>=arr[i-1]) {
                        dp[i][j] = dp[i-1][j]+dp[i-1][j-arr[i-1]];
                        System.out.print("");
                    }
                }
            }
        return dp[dp.length-1][dp[0].length-1];

    }


}
