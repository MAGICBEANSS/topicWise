package org.dsa.topics.lis;

import java.util.*;

public class LISBruteForce {

    private static int maxlength = Integer.MIN_VALUE;
    public static void main(String[] args) {
        int[] arr = {0,1,0,3,2,3};
        //int[] arr = {7,7,7,7,7,7,7};

        // System.out.println(maxlength);
        int z = lengthOfLIS(arr);
        System.out.println(z);
    }
    private static int[][] dp;
    private static Map<String,Integer> hp;

    public static int lengthOfLIS(int[] arr) {
        int max = Arrays.stream(arr).max().getAsInt();
        hp =  new HashMap<>();
        dp = new int[arr.length][arr.length+1];
        initDP(dp);
        return solveLISBruteForceSimpleIndex(arr,0,-1);
    }
    private static void initDP(int[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i],-1);
        }
    }




    private static int solveLISBruteForceSimpleIndex(int[] arr, int i, int lastVisitedIndex) {
        if(i>=arr.length) {
            return 0;
        }
        if(dp[i][lastVisitedIndex+1]!=-1) {
            return dp[i][lastVisitedIndex+1];
        }
        int countWithTaking = 0;
        if(lastVisitedIndex==-1 || arr[i]>arr[lastVisitedIndex]) {
            countWithTaking =  1+solveLISBruteForceSimpleIndex(arr,i+1,i);
        }
        int countWithoutTaking = solveLISBruteForceSimpleIndex(arr,i+1,lastVisitedIndex);
        int max= Math.max(countWithoutTaking,countWithTaking);
        dp[i][lastVisitedIndex+1]= max;
        return max;
    }

    private static int solveLISBruteForceSimple(int[] arr, int i, int lastVisited) {
        if(i>=arr.length) {
            return 0;
        }
        String key = i+","+lastVisited;
        if(hp.containsKey(key)) {
            return hp.get(key);
        }
        int countWithTaking = 0;
        if(arr[i]>lastVisited) {
            countWithTaking =  1+solveLISBruteForceSimple(arr,i+1,arr[i]);
        }
        int countWithoutTaking = solveLISBruteForceSimple(arr,i+1,lastVisited);
        int max= Math.max(countWithoutTaking,countWithTaking);
        hp.put(key,max);
        return max;
    }



    private static int solveLISBruteForce(int[] arr, int i, int count, int lastVisited) {
        if(i>=arr.length) {
            //    maxlength = Math.max(maxlength,count);
            return count;
        }

        int countWithTaking = 0;

        if(arr[i]>lastVisited) {

            //  int countWithoutTaking =  solveLISBruteForce(arr,i+1,count,lastVisited);
            countWithTaking =  solveLISBruteForce(arr,i+1,count+1,arr[i]);

        }
        int countWithoutTaking = solveLISBruteForce(arr,i+1,count,lastVisited);
        return   Math.max(countWithoutTaking,countWithTaking);


        /*else {
            int countWithoutTaking = solveLISBruteForce(arr,i+1,count,lastVisited);
            int countWithNewStart = solveLISBruteForce(arr,i+1,1,arr[i]);
            *//*if(countWithoutTaking>countWithNewStart) return countWithoutTaking;
            else return 0;*//*
            return Math.max(
                    countWithNewStart,
                    countWithoutTaking
            );
        }*/

    }
}
