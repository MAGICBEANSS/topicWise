package org.dsa.topics.lcs;

import java.util.Arrays;

public class PrintLCSString {
    private static int[][] dp ;
    private static StringBuilder sol;

    public static void main(String[] args) {
        String str = "abcde";
        String t = "ace";
        System.out.println(longestCommonSubsequence(t,str));
    }

    public static String longestCommonSubsequence(String text1, String text2) {
        dp = new int[text1.length()+1][text2.length()+1];
        initDP(dp);
        StringBuilder sb1 = new StringBuilder();
      //   printUsingMemoization(text1,text2,0,0,sb1);
         return new String(sb1);
    }

  /*  private static String printUsingMemoization(String s, String t, int si, int ti,StringBuilder sb) {
        if(si==s.length() || ti==t.length())
            return new String(sb);
        if(dp[si][ti]!=-1) {
            return ""
           // return dp[si][ti];
        }
        if(s.charAt(si)==t.charAt(ti)) {
            sb.append(s.charAt(si));
          return 1+printUsingMemoization(s,t,si+1,ti+1,sb);
        }
        else {
            StringBuilder stringBuilder = new StringBuilder();
           return Math.max( printUsingMemoization(s,t,si+1,ti,stringBuilder),
            printUsingMemoization(s,t,si,ti+1,stringBuilder)
            );


        }
    }*/


    private static void initDP(int[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i],-1);
        }
    }
}
