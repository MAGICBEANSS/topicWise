package org.dsa.topics.lcs;

import java.util.Arrays;

public class LongestCommonSubsequenceMemoization {
    private static int[][] dp ;

    public static void main(String[] args) {
        String str = "abcde";
        String t = "ace";
        System.out.println(longestCommonSubsequence(t,str));
    }

    public static int longestCommonSubsequence(String text1, String text2) {
        dp = new int[text1.length()+1][text2.length()+1];
           initDP(dp);
        //  return solveUsingRecursion(text1,text2,0,0,0);
        return solveUsingMemoization(text1,text2,0,0);
        //    return solveUsingDP(text1,text2);
    }

    public static int solveUsingMemoization(String s,String t,int si,int ti) {
        if(ti>=t.length() || si>=s.length()) {
            return 0;
        }
        if(s.charAt(si)==t.charAt(ti)) {
            if(dp[si+1][ti+1]==-1){
                dp[si+1][ti+1] = 1+solveUsingMemoization(s,t,si+1,ti+1);
                int x = 3;
            }
            return dp[si+1][ti+1];
        }
        else {
            if(dp[si+1][ti+1]==-1){
                dp[si+1][ti+1] =  Math.max(
                        solveUsingMemoization(s,t,si+1,ti),
                        solveUsingMemoization(s,t,si,ti+1)
                );
            }
            return dp[si+1][ti+1];
        }
    }

    private static void initDP(int[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i],-1);
        }
    }

}
