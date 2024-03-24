package org.dsa.topics.recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GridUniquePaths {

    //https://takeuforward.org/data-structure/grid-unique-paths-2-dp-9/
    public static void main(String[] args) {
        int[][] grid = {{0,0,0},{0,1,0},{0,0,0}};
        List<List<Pair>> allPaths = new ArrayList<>();
        findAllPath(grid,grid.length,grid[0].length,0,0,allPaths,new ArrayList<Pair>());
        allPaths.stream().forEach(System.out::println);
        return;

    }

    private static void findAllPath(int[][] grid, int m, int n, int i, int j, List<List<Pair>> allPaths, ArrayList<Pair> currentSol) {
            if(i>=m|| j>=n ) return;
            if(grid[i][j]==1) {
                return;
            }
            if(i==(m-1) && j==(n-1)) {
                currentSol.add(new Pair(i,j));
                allPaths.add(new ArrayList<>(currentSol));
                currentSol.remove(currentSol.size()-1);
                return;
            }

            Pair pair = new Pair(i,j);
            currentSol.add(pair);
            int x = grid[i][j];
            grid[i][j] = 1;
            findAllPath(grid,m,n,i+1,j,allPaths,currentSol);
            findAllPath(grid,m,n,i,j+1,allPaths,currentSol);
            grid[i][j] = x;
            currentSol.remove(currentSol.size()-1);

    }


}

class Pair{
    int x;
    int y;
    Pair(int x,int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "{" + x +
                "," + y +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        return x == pair.x && y == pair.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
