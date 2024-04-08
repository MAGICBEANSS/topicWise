package org.dsa.topics.lis;

import java.util.*;

public class longestDivisorSequence {
    private static int[] dp;
    private static Map<String,List<Integer>> hp;
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        System.out.println(largestDivisibleSubset(arr));
    }

    public static List<Integer> largestDivisibleSubset(int[] arr) {
        List<Integer> result = new ArrayList<>();
        Arrays.sort(arr);
        dp = new int[arr.length+1];
        hp = new HashMap<>();
        initi(dp);
        result = largestDivisibleSubset(arr, 0, 1, result);
        return result;

    }

    private static void initi(int[] dp) {
            Arrays.fill(dp,-1);
    }

    public static List<Integer> largestDivisibleSubset(int[] arr, int i, int prevNo, List<Integer> currentList) {
        if (i >= arr.length) {
            return currentList;
        }

        String key = i+","+prevNo+currentList;
        if(hp.containsKey(key)) {
            return hp.get(key);
        }

        List<Integer> forwardListNotTakingIt = new ArrayList<>();
        forwardListNotTakingIt = largestDivisibleSubset(arr, i + 1, prevNo, forwardListNotTakingIt);


        List<Integer> forwardListTakingIt = new ArrayList<>();

        if (arr[i] % prevNo == 0 || prevNo % arr[i] == 0) {
            int no = Math.max(prevNo, arr[i]);

            forwardListTakingIt.add(arr[i]);
            forwardListTakingIt = largestDivisibleSubset(arr, i + 1, no, forwardListTakingIt);
        }
        List<Integer> result = forwardListTakingIt.size() > forwardListNotTakingIt.size() ? forwardListTakingIt : forwardListNotTakingIt;
        currentList.addAll(result);
        hp.put(key,result);
        return currentList;
    }
}
