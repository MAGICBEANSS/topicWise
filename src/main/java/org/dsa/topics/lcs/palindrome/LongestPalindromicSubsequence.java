package org.dsa.topics.lcs.palindrome;

import java.util.Arrays;

public class LongestPalindromicSubsequence {
//https://leetcode.com/problems/longest-palindromic-subsequence/description/

    /**
     * say we have string "agbcba";
     * Its longest palindromic subsequence will be abcba;
     * How ?
     * Reverse the string => abcbga;
     * Now we have two string "agbcba" and "abcbga"
     * If we calculate LPS of these two ==> abcba
     * This is the longest palindromic subsequence;
     * @param args
     */

    static int[][] memo;
    public static void main(String[] args) {
        String str = "agbcba";
        System.out.println(findLPS(str));
    }

    private static String findLPS(String str) {
        String rev = new StringBuilder(str).reverse().toString();
        memo= new int[str.length()+1][rev.length()+1];
        initMemo();
        int z = getLCS(str,rev,str.length(),rev.length());
        String s = printLCS(str,rev);
        return s;
    }

    private static String printLCS(String str, String rev) {
        StringBuilder sb = new StringBuilder();
        for (int i = memo.length-1; i >0; ) {
            for (int j = memo[0].length-1; j >0; ) {
                if(str.charAt(i-1)==rev.charAt(j-1)) {
                    sb.append(str.charAt(i-1));
                    i--;j--;
                }
                else {
                    if(memo[i-1][j]>memo[i][j-1]){
                        i=i-1;
                    }
                    else {
                        j=j-1;
                    }
                }
            }
        }
        return new String(sb);
    }

    private static int getLCS(String str, String rev, int i, int j) {
        if(i==0||j==0) return 0;
        if(memo[i][j]!=-1){
            return memo[i][j];
        }
        else {
            if(str.charAt(i-1)==rev.charAt(j-1)) {
                memo[i][j] =1+ getLCS(str,rev,i-1,j-1);
            }
            else {
                memo[i][j] = Math.max(
                        getLCS(str,rev,i,j-1),
                        getLCS(str,rev,i-1,j)
                );
            }

            return memo[i][j];
        }
    }

    private static void initMemo() {
        for (int i = 0; i < memo.length; i++) {
            Arrays.fill(memo[i],-1);
        }
    }
}
