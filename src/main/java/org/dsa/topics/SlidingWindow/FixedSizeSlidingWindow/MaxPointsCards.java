package org.dsa.topics.SlidingWindow.FixedSizeSlidingWindow;

public class MaxPointsCards {
    //https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/description/
    public static void main(String[] args) {
        int[] arr = {5,6,1,4,2,10,1};
        int result = maxScore(arr,3);
        System.out.println(result);
    }

    /**
     *
     * So we have to pick elements from boundaries .
     * If you write it on a piece of paper you will realise we mostly revolve around edges
     * to pick the elements, And elements not picked will always be a subarray i.e. are contigous
     * We cannot omit any of the sequence while picking , either we pick from one of the boundary or not
     *
     *
     * So we have to pick the max sum of length k
     * So out of n nos we have to pick k no from boundaries with max sum
     * so other elements i.e. unpicked one will have min sum
     * How many unpicked elements will be there in an array of length n , if we pick k from it
     * Definetely n-k;
     * Now sum of these  n-k elements needs to be minimum to make picked k elements  maximum
     * So we have to find min sum subarray of size n-k
     * and then we subtract that from total sum
     * That's the solution
     *
     */

    public  static int maxScore(int[] arr, int k) {
        int totalSum=0;
        for (int i = 0; i < arr.length; i++) {
            totalSum+=arr[i];
        }
        int minSum = finMinSumOfSizeNK(arr,arr.length,arr.length-k);
        System.out.println("totalSum="+totalSum+" minSum="+minSum+" length="+(arr.length-k));
        return totalSum-minSum;
    }

    private static int finMinSumOfSizeNK(int[] arr, int n, int k) {
        int minsum = Integer.MAX_VALUE;
        int currsum = 0;
        for (int j = 0; j < k; j++) {
               currsum+=arr[j];
        }
        minsum = currsum;
        for (int j = k; j < n; j++) {
            int outgoingIndex= j-k;
            currsum=currsum-arr[outgoingIndex];
            currsum=currsum+arr[j];
            if(minsum>currsum) minsum=currsum;
        }
        return minsum;
    }
}
