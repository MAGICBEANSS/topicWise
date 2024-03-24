package org.dsa.topics.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayPartitionWithMinDifference {
//https://leetcode.com/problems/partition-array-into-two-arrays-to-minimize-sum-difference/
    public static void main(String[] args) {
    //int[] arr = {-36,36};
    int[] arr = {76,8,45,20,74,84,28,1};
    int n = arr.length;
        System.out.println(minSubsetSumDifference(arr,n));
    }

    public static int minSubsetSumDifference(int []arr, int n) {
        // Write your code here.
        int max = Arrays.stream(arr).max().getAsInt();
      //  return minSubsetSumDifference(arr,n,0,0,0,Integer.MAX_VALUE,0,0);
        return minSubsetSumDifferenceDebug(arr,n,0,0,0,Integer.MAX_VALUE,new ArrayList<>(),new ArrayList<>());
    }

    public static int minSubsetSumDifference(int []arr, int n,int i,int sumA,int sumB,Integer min,int lc,int rc) {
        // Write your code here.
        if (i == n ) {
            if((lc != 0 && rc != 0)) {
                min = Math.min(min, Math.abs(sumB - sumA));
            }
            return min;
        }


        return Math.min(minSubsetSumDifference(arr,n,i+1,sumA+arr[i],sumB,min,lc+1,rc),minSubsetSumDifference(arr,n,i+1,sumA,arr[i]+sumB,min,lc,rc+1));
    }

    public static int minSubsetSumDifferenceDebug(int []arr, int n, int i, int sumA, int sumB, Integer min, List<Integer> lc, List<Integer> rc) {
        // Write your code here.
        if (i == n ) {
            if((lc.size() != 0 && rc.size() != 0)) {
                min = Math.min(min, Math.abs(sumB - sumA));
                System.out.println("SetA ="+lc+" sumA="+sumA+" setB="+rc+" sumB="+sumB+" min="+min);
            }
            return min;
        }
        lc.add(arr[i]);
        int minL = minSubsetSumDifferenceDebug(arr,n,i+1,sumA+arr[i],sumB,min,lc,rc);
        lc.remove(lc.size()-1);
        rc.add(arr[i]);
        int minR = minSubsetSumDifferenceDebug(arr,n,i+1,sumA,arr[i]+sumB,min,lc,rc);
        rc.remove(rc.size()-1);
        return Math.min(minL,minR);

    }
}
