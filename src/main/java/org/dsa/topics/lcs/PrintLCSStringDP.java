package org.dsa.topics.lcs;

import java.util.Arrays;

public class PrintLCSStringDP {
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
        findLCSDP(text1,text2);
         printUsingDP(text1,text2);
         return new String(sb1);
    }

    private static void printUsingDP(String text1, String text2) {
        StringBuilder sb = new StringBuilder();
        for (int i = dp.length-1; i >=1; ) {
            for (int j = dp[0].length-1; j >=1 && i>=1; ) {
                if(text1.charAt(i-1)==text2.charAt(j-1)) {
                    sb.append(text1.charAt(i-1));
                    i--;
                    j--;
                }
                else {
                    if(dp[i-1][j]>dp[i][j-1]) {
                        i = i-1;
                    }
                    else {
                        j = j-1;
                    }
                }
            }
        }
        System.out.println(new String(sb));
    }

    private static void findLCSDP(String text1, String text2) {
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                if(text1.charAt(i-1)==text2.charAt(j-1)) {
                    dp[i][j] = 1+dp[i-1][j-1];
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
