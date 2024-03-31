
package org.dsa.topics.lcs;

import java.util.Arrays;

public class LongestCommonSubstringDP {

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
       solveUsingDP(S1,S2);
       return dp[dp.length-2][dp[0].length-2];
    }

    private static void solveUsingDP(String s1, String s2) {
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp.length; j++) {
                if(s1.charAt(i-1)==s2.charAt(i-1)) {
                    dp[i][j] = 1+dp[i-1][j-1];
                    max = Math.max(max,dp[i][j]);
                }
            }
        }
    }

    private static void initDP(int[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i],0);
        }
    }



}

