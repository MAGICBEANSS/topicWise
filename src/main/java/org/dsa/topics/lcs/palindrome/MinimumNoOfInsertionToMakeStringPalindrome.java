package org.dsa.topics.lcs.palindrome;

public class MinimumNoOfInsertionToMakeStringPalindrome {

    //https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/submissions/1218559228/

    static int[][] dp;
    public static void main(String[] args) {
        String str = "agbcba";
        System.out.println(solve(str));
    }

    private static int solve(String str) {
        String rev = new StringBuilder(str).reverse().toString();
        dp = new int[str.length()+1][rev.length()+1];
        initDPMat(dp);
        int lcs_length= initDPMat(str,rev);
        return str.length()-lcs_length;
    }

    private static int initDPMat(String str, String rev) {
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if(str.charAt(i-1)==rev.charAt(j-1)) {
                    dp[i][j] = 1+dp[i-1][j-1];
                }
                else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }

    private static void initDPMat(int[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if(i==0||j==0) {
                    dp[i][j] = 0;
                }
            }

        }
    }
}
