package org.dsa.topics.unbounded;

import java.util.Arrays;

public class MinNoOfCoinsForSum {
//https://www.geeksforgeeks.org/problems/coin-change2448/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=bottom_sticky_on_article

    public static void main(String[] args) {
        int[] arr = {9, 6, 5, 1};
    
        int sum = 11;
        int zrec = findAllWaysRecursion(arr,0,0,sum,0);
        //long z = findAllWaysDP2(arr,sum);
        System.out.println(zrec);
     //   System.out.println(zrec);

    }

    private static int findAllWaysRecursion(int[] arr, int sum,int i,int target,int count) {

        if(sum==target) {
            return count;
        }
        if(i>=arr.length || sum>target) {
            return Integer.MAX_VALUE;
        }

        int countTakingIt =  findAllWaysRecursion(arr,sum+arr[i],i,target,count+1);
        int countWithoutTakingIt =  findAllWaysRecursion(arr,sum,i+1,target,count);
        return Math.min(countTakingIt,countWithoutTakingIt);
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
