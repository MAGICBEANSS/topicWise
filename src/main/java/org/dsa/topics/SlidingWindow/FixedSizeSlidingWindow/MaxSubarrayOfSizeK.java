package org.dsa.topics.SlidingWindow.FixedSizeSlidingWindow;

import java.util.HashSet;
import java.util.Set;

public class MaxSubarrayOfSizeK {
//leetcode.com/problems/maximum-sum-of-distinct-subarrays-with-length-k/
    public static void main(String[] args) {
        int[] arr = {1,2};
        long maxsum = findMaxSumOfSubarrayWithLengthK(arr,1);
        System.out.println(maxsum);
    }

    private static long findMaxSumOfSubarrayWithLengthK(int[] arr,int k) {
        return maximumSubarraySum(arr,k);
    }

    public static long maximumSubarraySum(int[] nums, int k) {

        Set<Integer> set = new HashSet<>();
        int i =0;
        int j =0;
        int n =nums.length;
        int sum = 0;
        while(j<k){
            sum+=nums[j];
            j++;
        }
        int maxsum = sum;
        while( j<n) {
            sum  = sum-nums[j-k]+nums[j];
            maxsum = Math.max(sum,maxsum);
            j++;
        }
        return maxsum;
    }
}
