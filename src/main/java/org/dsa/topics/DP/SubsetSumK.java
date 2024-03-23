package org.dsa.topics.DP;

public class SubsetSumK {
    //https://www.geeksforgeeks.org/subset-sum-problem-dp-25/
    private static int cc = 0;

    public static void main(String[] args) {
        int[] set = {3, 34, 4, 4, 54};
        int sum = 7;
        int[][] matrix = new int[set.length+1][sum+1];
        filler(matrix,set.length+1,sum+1);
    //    System.out.println(solveUsingRecursion(set,0,sum));
        System.out.println(solveUsingRecursionMemoizedCC(set,0,sum,matrix));
        System.out.println("cc="+cc);
        cc=0;
        System.out.println(solveUsingRecursionCC(set,0,sum));
        System.out.println("cc="+cc);
        filler(matrix,set.length+1,sum+1);
        System.out.println(solveUsingDP(set,matrix));
      //  System.out.println("cc="+cc);

    }

    private static void filler(int[][] matrix,int maxi,int maxj) {
        for (int i = 0; i < maxi; i++) {
            for (int j = 0; j < maxj; j++) {
                if(j==0) {
                    matrix[i][j] = 1;
                }
                else if(i==0) {
                    matrix[i][j] = 0;
                }
                else {
                    matrix[i][j]=-1;
                }
            }

        }
    }

    private static boolean solveUsingRecursion(int[] arr, int i,int toGet){
        if(toGet==0){
            return true;
        }
        if(i>=arr.length) return false;
        if(toGet<arr[i]) {
            return solveUsingRecursion(arr,i+1,toGet);
        }
        else {
            return solveUsingRecursion(arr,i+1,toGet) || solveUsingRecursion(arr,i+1,toGet-arr[i]);
        }
    }

    private static boolean solveUsingRecursionCC(int[] arr, int i,int toGet){
        if(toGet==0){
            return true;
        }
        if(i>=arr.length) return false;
        if(toGet<arr[i]) {
            cc++;
            return solveUsingRecursionCC(arr,i+1,toGet);
        }
        else {
            cc+=2;
            return solveUsingRecursionCC(arr,i+1,toGet) || solveUsingRecursionCC(arr,i+1,toGet-arr[i]);
        }
    }

    private static int solveUsingRecursionMemoized(int[] arr, int i,int toGet,int[][] matrix){
        if(toGet==0){
            return 1;
        }
        if(i>=arr.length || toGet<0) {
            return 0;
        }

        if(matrix[i+1][toGet]!=-1) {
            return matrix[i+1][toGet];
        }

        if(toGet<arr[i]) {
                matrix[i+1][toGet] = solveUsingRecursionMemoized(arr,i+1,toGet,matrix);
            return matrix[i+1][toGet];
        }
        else {
                matrix[i+1][toGet]= ((solveUsingRecursionMemoized(arr,i+1,toGet,matrix)==1) ||
                        ( solveUsingRecursionMemoized(arr,i+1,toGet-arr[i],matrix) ==1)) ? 1:0;

            return  matrix[i+1][toGet];
        }
    }

    private static int solveUsingRecursionMemoizedCC(int[] arr, int i,int toGet,int[][] matrix){
        if(toGet==0){
            return 1;
        }
        if(i>=arr.length || toGet<0) {
            return 0;
        }

        if(matrix[i+1][toGet]!=-1) {
            return matrix[i+1][toGet];
        }

        if(toGet<arr[i]) {
            cc++;
            matrix[i+1][toGet] = solveUsingRecursionMemoizedCC(arr,i+1,toGet,matrix);
            return matrix[i+1][toGet];
        }
        else {
            cc+=2;
            matrix[i+1][toGet]= ((solveUsingRecursionMemoizedCC(arr,i+1,toGet,matrix)==1) ||
                    ( solveUsingRecursionMemoizedCC(arr,i+1,toGet-arr[i],matrix) ==1)) ? 1:0;

            return  matrix[i+1][toGet];
        }
    }

    private static int solveUsingDP(int[] arr,int[][] dp){
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if(j<arr[i-1]) {
                    dp[i][j]=dp[i-1][j];
                    int z = 1;
               }
                else {
                    dp[i][j] = dp[i - 1][j] | dp[i - 1][j - arr[i-1]];
                   int z=1;
                }
            }
        }

        return dp[dp.length-1][dp[0].length-1];
    }
}
