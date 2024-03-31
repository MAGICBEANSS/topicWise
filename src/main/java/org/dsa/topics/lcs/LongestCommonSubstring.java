
package org.dsa.topics.lcs;

import java.util.Arrays;

public class LongestCommonSubstring {

    private static int max = Integer.MIN_VALUE;
    private static int[][] dp ;

    public static void main(String[] args) {
        String s = "ABC";
        String t = "AC";
       int z =  longestCommonSubstr(s,t,s.length(),t.length());
        System.out.println(z);
    }


   static int longestCommonSubstr(String S1, String S2, int n, int m){
        // code here
       dp = new int[S1.length()+1][S2.length()+1];
       initDP(dp);
       solveUsingRecursionMemoization(S1,S2,0,0,0);
       return dp[dp.length-2][dp[0].length-2];
    }

    private static void initDP(int[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i],-1);
        }
    }

    static int solveUsingRecursionMemoization(String s,String t, int si,int ti,int count) {

        if(si==s.length()) {
            return count;
        }
        else if(ti==t.length()) {
            return count;
        }

        if(dp[si][ti]!=-1) {
            System.out.println("Not Resolving for si="+si+" and ti="+ti);
            return dp[si][ti];
        }

        if(s.charAt(si)==t.charAt(ti)) {
                dp[si][ti] =  1+solveUsingRecursionMemoization(s, t, si + 1, ti + 1,count+1);
        }
        else{
            dp[si][ti] =  Math.max(count,
                    Math.max(
                            solveUsingRecursionMemoization(s,t,si,ti+1,0),
                            solveUsingRecursionMemoization(s,t,si+1,ti,0)
                    )
            );
        }
        return 0;

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

