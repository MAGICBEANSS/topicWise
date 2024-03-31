package org.dsa.topics.lcs;

import java.util.Arrays;

public class LongestCommonSubstringMemoization {

    private static int max = Integer.MIN_VALUE;
    private static int[][] dp ;

    public static void main(String[] args) {
        String s = "XZABC";
        String t = "ABCXZ";
        int z =  longestCommonSubstr(s,t,s.length(),t.length());
        System.out.println(max);
    }


   static int longestCommonSubstr(String S1, String S2, int n, int m){
        // code here
       dp = new int[S1.length()+1][S2.length()+1];
       initDP(dp);
       int z =solveUsingRecursionMemoization(S1,S2,0,0);
       return z;
    }

    private static void initDP(int[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i],-1);
        }
    }

    static int solveUsingRecursionMemoization(String s,String t, int si,int ti) {

        if(si==s.length()) {
            return 0;
        }
        else if(ti==t.length()) {
            return 0;
        }

        if(dp[si][ti]!=-1) {
         //   System.out.println("Not Resolving for si="+si+" and ti="+ti);
            return dp[si][ti];
        }
        dp[si][ti]=0;
        if(s.charAt(si)==t.charAt(ti)) {
                dp[si][ti] =  1+solveUsingRecursionMemoization(s, t, si + 1, ti + 1);
        }

            solveUsingRecursionMemoization(s, t, si, ti + 1);
            solveUsingRecursionMemoization(s, t, si + 1, ti);

        max = Math.max(max, dp[si][ti]);
        return dp[si][ti];

    }

    public static int solveUsingMemoization2(String s, String t, int si, int ti, int count, int[][] dp) {
        // Check if si or ti has reached the end of their respective strings
        if (si == s.length() || ti == t.length()) {
            return count;
        }
        // If the result is already computed, return it from the memoization table
        if (dp[si][ti] != -1) {
            return dp[si][ti];
        }
        int result = count;
        // If characters match, recursively check next characters
        if (s.charAt(si) == t.charAt(ti)) {
            result = solveUsingMemoization2(s, t, si + 1, ti + 1, count + 1, dp);
        } else {
            // If characters don't match, start counting from 0 and check next characters
            result = Math.max(result,
                    Math.max(
                            solveUsingMemoization2(s, t, si, ti + 1, 0, dp),
                            solveUsingMemoization2(s, t, si + 1, ti, 0, dp)
                    )
            );
        }
        // Store the result in the memoization table
        dp[si][ti] = result;
        return result;
    }

    static int solveUsingRecursion(String s,String t, int si,int ti,int count) {

        if(si==s.length()) {
            return count;
        }
        else if(ti==t.length()) {
            return count;
        }
        if(s.charAt(si)==t.charAt(ti)) {
            return solveUsingRecursion(s,t,si+1,ti+1,count+1);
        }
        else{
            return Math.max(count,
             Math.max(
                    solveUsingRecursion(s,t,si,ti+1,0),
                    solveUsingRecursion(s,t,si+1,ti,0)
            )
            );
        }

    }


}

