package org.dsa.topics.recursion;

import java.util.ArrayList;
import java.util.List;


public class RatMazePath {

    static int m =4;
    static int n =4;
    private static int[][] grid = null;
    public static void main(String[] args) {
        grid= new int[][]{{1, 0, 0, 0},
                {1, 1, 0, 1},
                {1, 1, 0, 0},
                {0, 1, 1, 1}};
        List<List<String>> allPaths = new ArrayList<>();
        getMazePaths(new ArrayList<>(),allPaths,0,0,m,n,null);
        allPaths.stream().forEach(strings -> System.out.println(strings));
    }

    public static void getMazePaths(List<String> result,List<List<String>> allPaths,int i,int j,int m,int n,String op) {
        if(i>=m|| j>=n || i<0||j<0 ) return;
        if(grid[i][j]==0) {
            return;
        }
        if(i==(m-1) && j==(n-1)) {
            allPaths.add(new ArrayList<>(result));
            return;
        }
        int x = grid[i][j];
        grid[i][j] = 0;
        op = "D";
        result.add(op);
        getMazePaths(result,allPaths,i+1,j,m,n,op);
        result.remove(result.size()-1);
        op = "L";
        result.add(op);
        getMazePaths(result,allPaths,i,j-1,m,n,op);
        result.remove(result.size()-1);
        op = "R";
        result.add(op);
        getMazePaths(result,allPaths,i,j+1,m,n,op);
        result.remove(result.size()-1);
        op = "T";
        result.add(op);
        getMazePaths(result,allPaths,i-1,j,m,n,op);
        result.remove(result.size()-1);
        grid[i][j]=x;



    }
}

