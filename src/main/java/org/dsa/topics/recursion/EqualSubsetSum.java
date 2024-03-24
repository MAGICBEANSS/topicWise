package org.dsa.topics.recursion;

import java.util.Arrays;

public class EqualSubsetSum {

    //https://leetcode.com/problems/partition-equal-subset-sum/description/
    public static void main(String[] args) {
        int[] arr =  {1,5,11,5};
        int total = Arrays.stream(arr).sum();
        System.out.println(total%2==0 && equalPartitionII(arr,total,0,0));

    }


    static boolean equalPartitionII( int arr[],int totalSum,int currentSum,int i) {
        if(i==arr.length) {
            return false;
        }
        int no = arr[i];
        if((currentSum+no)== (totalSum/2)){
            return true;
        }
        return equalPartitionII(arr,totalSum,currentSum,i+1) || equalPartitionII(arr,totalSum,currentSum+no,i+1);

    }

    }
