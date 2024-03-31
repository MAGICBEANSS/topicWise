package org.dsa.topics.lcs;

import java.util.Arrays;

public class MaxLengthOfRepeatedSubarrayDP {
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
        findLengthDP(nums1,nums2);
        return max==Integer.MIN_VALUE ? 0:max;
    }

    public static int findLengthDP(int[] nums1, int[] nums2) {
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if(nums1[i-1]==nums2[j-1]) {
                    dp[i][j] = 1+dp[i-1][j-1];
                    max = Math.max(max,dp[i][j]);
                }
            }
        }
        return max;
    }

    private static void init(int[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i],0);
        }
    }
}
