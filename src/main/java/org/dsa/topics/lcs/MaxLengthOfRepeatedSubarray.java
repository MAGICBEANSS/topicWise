package org.dsa.topics.lcs;

import java.util.Arrays;

public class MaxLengthOfRepeatedSubarray {
    static int max  = Integer.MIN_VALUE;
    static int[][] dp;

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,2,1};
        int[] nums2 = {3,2,1,4,7};
        System.out.println(findLength(nums1,nums2));

    }

    public static int findLength(int[] nums1, int[] nums2) {
        dp = new int[nums1.length+1][nums2.length+1];
        init(dp);
        findLengthMemoization(nums1,nums2,0,0);
        return max==Integer.MIN_VALUE ? 0:max;
    }

    public static int findLengthMemoization(int[] nums1, int[] nums2,int n1,int n2) {
       if(n1==nums1.length|| n2==nums2.length){
            return 0;
       }
       if(dp[n1][n2]!=-1){
           return dp[n1][n2];
       }
        dp[n1][n2]=0;
       if(nums1[n1]==nums2[n2]) {
           dp[n1][n2] =  1+findLengthMemoization(nums1,nums2,n1+1,n2+1);
       }
        findLengthMemoization(nums1,nums2,n1+1,n2);
        findLengthMemoization(nums1,nums2,n1,n2+1);
       max = Math.max(max,dp[n1][n2]);
       return dp[n1][n2];
}

    private static void init(int[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i],-1);
        }
    }
}
