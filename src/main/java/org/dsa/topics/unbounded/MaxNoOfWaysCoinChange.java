package org.dsa.topics.unbounded;

import java.util.Arrays;

public class MaxNoOfWaysCoinChange {
//https://www.geeksforgeeks.org/problems/coin-change2448/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=bottom_sticky_on_article

    public static void main(String[] args) {
        int[] arr = {89, 62, 82, 87, 88, 53, 29, 16, 50, 95, 70, 32, 17, 57, 3, 61, 44, 91, 24, 72, 94, 34, 90, 52, 7,
                65, 22, 15, 92, 38, 60, 63, 78, 64, 55, 36, 46, 85, 30, 11, 12, 33, 96, 45, 13, 4, 98, 40, 93, 83, 1, 42};

        int sum = 432;
     //   int z = findAllWaysRecursion(arr,0,0,sum);
        long z = findAllWaysDP2(arr,sum);
        long z1 = countme(arr,arr.length,sum);
        System.out.println(z);
        System.out.println(z1);

    }

    private static int findAllWaysRecursion(int[] arr, int sum,int i,int target) {

        if(sum==target) {
            return 1;
        }
        if(i>=arr.length || sum>target) {
            return 0;
        }

        int countTakingIt =  findAllWaysRecursion(arr,sum+arr[i],i,target);
        int countWithoutTakingIt =  findAllWaysRecursion(arr,sum,i+1,target);
        return countTakingIt+countWithoutTakingIt;

    }

    private static long findAllWaysDP(int[] arr, int target) {
        long[][] dp = new long[arr.length+1][target+1];
        init(dp);
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] = dp[i-1][j];
                if(j>=arr[i-1]) {
                    dp[i][j] = dp[i-1][j]+dp[i][j-arr[i-1]];
                }
            }
        }

        return dp[dp.length-1][dp[0].length-1];
    }

    private static long findAllWaysDP2(int[] arr, int target) {
        long[][] dp = new long[arr.length+1][target+1];
        long[] dp1 = new long[target+1];
        dp1[0] = 1;
        init(dp);
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] = dp[i-1][j];
                dp1[j] = dp1[j];
                if(j>=arr[i-1]) {
                    dp[i][j] = dp[i-1][j]+dp[i][j-arr[i-1]];
                    dp1[j] = dp1[j]+dp1[j-arr[i-1]];

                }

            }
            Arrays.equals(dp1,dp[i]);
            System.out.println(dp[i]);
            System.out.println(dp1);
        }

        return dp[dp.length-1][dp[0].length-1];
    }

    public static long countme(int coins[], int N, int sum) {
        long[] dp = new long[sum+1];
        dp[0] = 1;

        for(int i=0;i<N;i++){
            for(int j=1;j<sum+1;j++){
                int coinValue = coins[i];

                if(j-coinValue>=0){
                    dp[j] = dp[j] + dp[j-coinValue];
                }
            }
        }
        return dp[sum];
    }




        private static void init(long[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if(j==0) {
                    dp[i][j]=1;
                }
            }

        }
    }
}
