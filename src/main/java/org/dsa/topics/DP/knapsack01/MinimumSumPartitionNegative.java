package org.dsa.topics.DP.knapsack01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class MinimumSumPartitionNegative {

    //https://www.geeksforgeeks.org/partition-a-set-into-two-subsets-such-that-the-difference-of-subset-sums-is-minimum/
    private static int minSum = Integer.MAX_VALUE;
    public static void main(String[] args) {
       // 1, 4
    //    int arr[] = {-36, 36};
        int arr[] = {2,-1,0,4,-2,-9};

        //   int arr[] = {1, 6, 11, 5};
        int z = minDifference(arr,arr.length);
        HashMap hm ;
        System.out.println(z);
    }

    private static int minSumPartition(int[] arr, int i,int totalsum,int sumTillNow) {
        int n = arr.length;
        if(i>=n) {
            int sumLeft = totalsum-sumTillNow;
            int diff= sumLeft-sumTillNow;
            return Math.abs(diff);
        }
            return Math.min(
                    minSumPartition(arr, i + 1, totalsum, sumTillNow),
                    minSumPartition(arr, i + 1, totalsum, sumTillNow + arr[i])
            );
    }

    private static int minSumPartitionMemoized(int[] arr, int i,int totalsum,int sumTillNow) {
        //int[][] matrix = DPFiller.filler(arr.length+1,totalsum,)
        int n = arr.length;
        if(i>=n) {
            int sumLeft = totalsum-sumTillNow;
            int diff= sumLeft-sumTillNow;
            return Math.abs(diff);
        }
        return Math.min(
                minSumPartition(arr, i + 1, totalsum, sumTillNow),
                minSumPartition(arr, i + 1, totalsum, sumTillNow + arr[i])
        );
    }

    private static int minSumPartitionDP(int[] arr,int totalsum) {
        int totalPositiveSum = 0;
        int totalNegativeSum = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]>0) {
                totalPositiveSum+=arr[i];
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]<0) {
                totalNegativeSum+=arr[i];
            }
        }
        int range = totalPositiveSum-totalNegativeSum;
  //      int[][] matrix = DPFiller.filler(arr.length+1,totalsum,1,-1)
        int[][] dp = DPFiller.filler(arr.length+1,range+1,1,0,-1);
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] = dp[i-1][j];
                if(arr[i-1]<=j) {
                    dp[i][j] = dp[i-1][j] | dp[i-1][j-arr[i-1]];
                }
            }
        }
        List<Integer> possibleSumList = new ArrayList<>();
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length/2+1; j++) {
                if(dp[i][j]>=0){
                    possibleSumList.add(j);
                }
            }
        }

        /**
         * We can optimise this possibleSumList actually
         * Since we want min difference, and we are using all elements
         * So count of elements we must require is n
         * Now we need to only iterate over for last element , because , all of them are required in any of the subset
         * now we want to maximise each sum (taken) and (left)
         * So we can start looping from sum/2+1 to left side or right side , and find  the first answer and stop
         * Why ?
         * Because whenever we are iterating from (n/2)+1 position , either left or right , the first possible sum we encounter
         * Is the maximum closest for a subset , for whcih conterpart will be lying also near to (n/2)
         * As both of them will have high value , so will be the sol
         */
        possibleSumList = new ArrayList<>();
        int maxCounterPartSum = Integer.MAX_VALUE;
        boolean found = false;
        for (int j = dp[0].length/2; j>=0  && !found; j--) {
            if(dp[dp.length-1][j]>=0) {
                maxCounterPartSum = j;
                found = true;
            }
        }
        int leftOver = totalsum-maxCounterPartSum;
        return Math.abs(leftOver-maxCounterPartSum);
/*            final int[] min = {Integer.MAX_VALUE};
        possibleSumList.stream().forEach(x->{
            int left = totalsum-x;
            if(left< min[0]) {
                min[0] = left;
            }
        });*/
     //   return min[0];

    }


    public static int minDifference(int arr[], int n)
    {
        int totalSum = Arrays.stream(arr).sum();
       minSum=  minSumPartitionDP(arr,totalSum);
         return minSum;
        // Your code goes here
    }

}
