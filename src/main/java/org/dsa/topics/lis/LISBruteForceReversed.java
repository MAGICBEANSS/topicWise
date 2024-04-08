package org.dsa.topics.lis;

import java.util.*;

public class LISBruteForceReversed {

    private static int maxlength = Integer.MIN_VALUE;
    public static void main(String[] args) {
        int[] arr = {10,9,2,5,3,7,101,18};
        //int[] arr = {7,7,7,7,7,7,7};

        // System.out.println(maxlength);
        int z = lengthOfLIS(arr);
        System.out.println(z);
    }
    private static int[] dp;
    private static Map<String,Integer> hp;

    public static int lengthOfLIS(int[] arr) {
        hp =  new HashMap<>();
        dp = new int[arr.length];
        initDP(dp);
        return printUsingTabulation(arr);
    }

    private static int solveTablulation(int[] arr) {

        if (arr.length == 0) {
            return 0;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = i-1; j >=0; j--) {
                if(arr[i]>arr[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
        }
        int max = Arrays.stream(dp).max().getAsInt();

        return max;
    }

    private static int printUsingTabulation(int[] arr) {
        int[] hash = new int[arr.length];
        for (int i = 0; i < hash.length; i++) {
            hash[i]=i;
        }

        if (arr.length == 0) {
            return 0;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = i-1; j >=0; j--) {
                if(arr[i]>arr[j]){
                    if(dp[j]>=dp[i])
                    {
                        dp[i] = dp[j]+1;
                        hash[i]=j;
                    }
                }
            }
        }
        int max = Arrays.stream(dp).max().getAsInt();
        printUsingHash(dp,max,hash,arr);
        return max;
    }

    private static void printUsingHash(int[] dp, int max, int[] hash, int[] arr) {
        int index=-1;
        for (int i = 0; i < dp.length; i++) {
            if(dp[i]==max){
                index = i;
                break;
            }
        }
        List<Integer> finalList = new ArrayList<>();
        finalList.add(arr[index]);
        while (hash[index]!=index) {
            int nextIndex = hash[index];
            finalList.add(arr[nextIndex]);
            index = nextIndex;
        }
        // add last time
        System.out.println(finalList);
    }

    private static void initDP(int[] dp) {
            Arrays.fill(dp,1);
    }


}
