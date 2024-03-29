package org.dsa.topics.lcs;

import java.util.HashMap;
import java.util.Map;

class Solution {
    private static Map<String, Integer> memo = new HashMap<>();

    static int solveUsingRecursion(String s, String t, int si, int ti) {
        String key = si + "," + ti;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int maxLen = 0;
        if (si < s.length() && ti < t.length() && s.charAt(si) == t.charAt(ti)) {
            maxLen = 1 + solveUsingRecursion(s, t, si + 1, ti + 1);
        }

        int left = solveUsingRecursion(s, t, si, ti + 1);
        int right = solveUsingRecursion(s, t, si + 1, ti);
        maxLen = Math.max(maxLen, Math.max(left, right));

        memo.put(key, maxLen);
        return maxLen;
    }

    public static void main(String[] args) {
        String s = "abcde";
        String t = "abfcde";
        int result = solveUsingRecursion(s, t, 0, 0);
        System.out.println("Length of the longest common substring: " + result);
    }
}