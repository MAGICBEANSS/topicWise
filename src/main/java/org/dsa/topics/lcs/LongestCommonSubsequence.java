package org.dsa.topics.lcs;

import java.util.Arrays;

public class LongestCommonSubsequence {

    private static int[][] dp ;
    public static void main(String[] args) {
        String str = "abcde";
        String t = "ace";
        System.out.println(longestCommonSubsequence(t,str));
    }

    public static int longestCommonSubsequence(String text1, String text2) {
             dp = new int[text1.length()+1][text2.length()+1];
         //   initDP(dp);
      //  return solveUsingRecursion(text1,text2,0,0,0);
        return solveUsingMemoization2(text1,text2,0,0);
    //    return solveUsingDP(text1,text2);
    }



    public static int solveUsingRecursion(String s,String t,int si,int ti,int count) {
        if(ti>=t.length() || si>=s.length()) {
            return count;
        }
        if(s.charAt(si)==t.charAt(ti)) {
            return solveUsingRecursion(s,t,si+1,ti+1,count+1);
        }
        else {
           return Math.max(
                    solveUsingRecursion(s,t,si+1,ti,count),
                    solveUsingRecursion(s,t,si,ti+1,count)
                    );
        }
    }

    public static int solveUsingMemoization(String s,String t,int si,int ti,int count) {
        if(ti>=t.length() || si>=s.length()) {
            return 0;
        }
        if(s.charAt(si)==t.charAt(ti)) {
            if(dp[si+1][ti+1]==-1){
                dp[si+1][ti+1] = 1+solveUsingMemoization(s,t,si+1,ti+1,count+1);
                int x = 3;
            }
           // return solveUsingRecursion(s,t,si+1,ti+1,count+1);
            return dp[si+1][ti+1];
        }
        else {
            if(dp[si+1][ti+1]==-1){
                dp[si+1][ti+1] =  Math.max(
                        solveUsingMemoization(s,t,si+1,ti,count),
                        solveUsingMemoization(s,t,si,ti+1,count)
                );
            }
            return dp[si+1][ti+1];
        }
    }

    public static int solveUsingMemoization2(String s,String t,int si,int ti) {
        if(ti>=t.length() || si>=s.length()) {
            return 0;
        }
        if(s.charAt(si)==t.charAt(ti)) {
            if(dp[si+1][ti+1]==-1){
                dp[si+1][ti+1] = 1+solveUsingMemoization2(s,t,si+1,ti+1);
                int x = 3;
            }
            return dp[si+1][ti+1];
        }
        else {
            if(dp[si+1][ti+1]==-1){
                dp[si+1][ti+1] =  Math.max(
                        solveUsingMemoization2(s,t,si+1,ti),
                        solveUsingMemoization2(s,t,si,ti+1)
                );
            }
            return dp[si+1][ti+1];
        }
    }


    public static int solveUsingDP(String s,String t) {

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if(s.charAt(i-1)==t.charAt(j-1)) {
                    dp[i][j] = 1+dp[i-1][j-1];
                }
                else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
            int z =23;
        }
        return dp[dp.length-1][dp[0].length-1];
    }

    private static void initDP(int[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i],-1);
        }
    }



}
