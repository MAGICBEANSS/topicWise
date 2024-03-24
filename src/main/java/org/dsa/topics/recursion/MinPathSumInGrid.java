package org.dsa.topics.recursion;

public class MinPathSumInGrid {

   // https://leetcode.com/problems/minimum-path-sum/description/
    public static void main(String[] args) {
        int[][] grid = {{1,2,3},{4,5,4},{7,5,9}};
        System.out.println(minSumPath(grid));
    }

    public static int minSumPath(int[][] grid) {
        // Write your code here.
        int m = grid.length;
        int n = grid[0].length;
        return minSumPath(grid,m,n,0,0,0,Integer.MAX_VALUE);
    }

    private static int minSumPath(int[][] grid, int m, int n, int i, int j, int sum,int min) {
        if(i==m || j==n) {
            return Integer.MAX_VALUE;
        }
        if(i==m-1 && j==n-1) {

            return Math.min(min,sum+grid[i][j]);
        }

        return Math.min(min,Math.min(minSumPath(grid,m,n,i+1,j,sum+grid[i][j],min),minSumPath(grid,m,n,i,j+1,sum+grid[i][j],min)));

    }
}
