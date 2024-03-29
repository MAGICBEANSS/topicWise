package org.dsa.topics.unbounded;

import java.util.Arrays;

public class MinNoOfCoinsForSumInteger {
//https://www.geeksforgeeks.org/problems/coin-change2448/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=bottom_sticky_on_article

    public static void main(String[] args) {
        int[] arr = {1};
    
        int sum = 0;
   //     int zrec = findAllWaysRecursion(arr,0,0,sum,0);
        long z = findAllWaysDPInt(arr,sum);
        System.out.println(z);
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



    private static int findAllWaysDPInt(int[] arr, int target) {
        int[][] dp = new int[arr.length+1][target+1];

        init(dp);
        // dp[0][0] = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] = dp[i-1][j];
                if(j>=arr[i-1] && dp[i][j-arr[i-1]] != Integer.MAX_VALUE) {
                    int sol = Math.min(dp[i-1][j],1+dp[i][j-arr[i-1]]);
                    if(sol==0 && j!=0) {
                        sol = Integer.MAX_VALUE;
                    }
                    dp[i][j] = sol;
                }
            }
        }

        int z =  dp[dp.length-1][dp[0].length-1];
        if(z==Integer.MAX_VALUE )
            z= -1;
        return z;
    }


        private static void init(int[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if(i==0) {
                    dp[i][j]=Integer.MAX_VALUE;
                }

            }

        }
    }
}
