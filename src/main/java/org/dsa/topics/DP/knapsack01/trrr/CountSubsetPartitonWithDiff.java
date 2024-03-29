package org.dsa.topics.DP.knapsack01.trrr;

import org.dsa.topics.DP.knapsack01.DPFiller;

import java.util.Arrays;

public class CountSubsetPartitonWithDiff {

    public static void main(String[] args) {
       // int[] arr = {5, 2, 6, 4};
    //    int[] arr = {1, 2, 3, 1, 2};
        int[] arr = {1,1,1,1};
        int diff = 0;
        System.out.println(countSubsets(arr,diff));
    }

    static int countSubsets(int[] arr,int diff) {
        int totalSum = Arrays.stream(arr).sum();
        int s1 ,s2 ;
         s2 = (totalSum-diff)/2;
        s1 = totalSum-s2;
        int minSum = s1>s2?s2:s1;
        int[][] dp = DPFiller.filler(arr.length+1,minSum+1,0,1,0);
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] = dp[i-1][j];
                    if(j>=arr[i-1]) {
                        dp[i][j] = dp[i-1][j]+dp[i-1][j-arr[i-1]];
                    }
            }
        }

        return dp[dp.length-1][dp[0].length-1];



    }


}
