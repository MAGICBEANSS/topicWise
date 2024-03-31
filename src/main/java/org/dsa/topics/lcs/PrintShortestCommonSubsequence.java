package org.dsa.topics.lcs;

public class PrintShortestCommonSubsequence {
    static int[][] dp;

    public static void main(String[] args) {
        System.out.println(solve("eke","geek"));
    }

    private static String solve(String str,String b) {
        dp = new int[str.length()+1][b.length()+1];
        initDPMat(dp);
        int lcs_length= solveDPMat(str,b);
        return printSCS(str,b);
    }

    private static String printSCS(String str, String b) {
        StringBuilder sb = new StringBuilder();
        int i =0;
        int j =0;
        for ( i = dp.length-1; i >0; ) {
            for ( j = dp[0].length-1; j > 0 && i>0;) {
                if(str.charAt(i-1)==b.charAt(j-1)) {
                    sb.append(str.charAt(i-1));
                    i--;j--;
                }
                else {
                    if(dp[i-1][j]>dp[i][j-1]) {
                        sb.append(str.charAt(i-1));
                        i--;
                        int x = 0;
                    }
                    else {
                        sb.append(b.charAt(j-1));
                        j--;
                        int x = 0;
                    }
                }
            }
        }
        while (j>0) {
            sb.append(b.charAt(j));
            j--;
        }
        while (i>0) {
            sb.append(str.charAt(i));
            i--;
        }
        return sb.reverse().toString();
    }

    private static int solveDPMat(String str, String rev) {
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
