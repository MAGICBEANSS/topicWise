package org.dsa.topics.unbounded;

public class RodcUTTING {

    public static void main(String[] args) {
        int[] rodcuts = {1,2,3,4,5,6,7,8};
      //  int[] prices = {1, 5, 8, 9, 10, 17, 17, 20};
        int[] prices = {3, 5, 8, 9, 10, 17, 17, 20};
        int rodLength = 8;
        int price = Integer.MIN_VALUE;
     //   int max = solveRodCutting(rodcuts,prices,rodcuts.length,rodLength,0,0);
        int max = solveRodCuttingDP(rodcuts,prices,rodcuts.length,rodLength);
        System.out.println(max);
    }

    private static int solveRodCutting(int[] rodcuts, int[] prices,
                                       int length, int rodLength, int i, int price) {
        if(rodLength==0) {
            return  price;
        }
        if(rodLength<0) {
            return 0;
        }
        if(i>=length) {
            return 0;
        }

        int profitWithTaking =
                solveRodCutting(rodcuts,prices,length,rodLength-rodcuts[i],i,price+prices[i]);
        int profitWithoutTaking =
                solveRodCutting(rodcuts,prices,length,rodLength,i+1,price);
        return Math.max(profitWithTaking,profitWithoutTaking);
    }

    private static int solveRodCuttingDP(int[] rodCuts, int[] prices,
                                       int length, int rodLength) {
       int[][] dp = new int[length+1][rodLength+1];
       init(dp);
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] = dp[i-1][j];
                if(j>=rodCuts[i-1]) {
                    dp[i][j] = Math.max(dp[i-1][j],prices[i-1]+dp[i][j-rodCuts[i-1]]);
                }
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }

    private static void init(int[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if(j==0) {
                    dp[i][j]=0;
                }
                else if(i==0) {
                    dp[i][j] = 0;
                }
            }

        }
    }
}
