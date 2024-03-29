package org.dsa.topics.unbounded;

public class MaxNoOfWaysCoinChangeMemoIzationLong {
//https://www.geeksforgeeks.org/problems/coin-change2448/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=bottom_sticky_on_article
   static long[][] dp;
    public static void main(String[] args) {
        int[] arr = {2,5,3,6};

        int sum = 10;
        dp = new long[arr.length][sum];
        init(dp);
     //   int z = findAllWaysRecursion(arr,0,0,sum);
        long z = findAllWaysMemoization(arr,0,0,sum);
        System.out.println(z);

    }

    private static void init(long[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j]=-1;
            }
        }
    }


    private static long findAllWaysMemoization(int[] arr, int sum,int i,int target) {

        if(sum==target) {
            return 1;
        }
        if(i>=arr.length || sum>target) {
            return 0;
        }
        if(dp[i][sum]!=-1) {
            return dp[i][sum];
        }

        long countTakingIt =  findAllWaysMemoization(arr,sum+arr[i],i,target);
        long countWithoutTakingIt =  findAllWaysMemoization(arr,sum,i+1,target);
        dp[i][sum] =  countTakingIt+countWithoutTakingIt;
        return dp[i][sum];
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




}
