package org.dsa.topics.theory;

public class NoOfIslandsRecursion {
    static int[][] area ;
    static boolean[][] visited ;

    public static void main(String[] args) {
        int[][] area = {{0, 1, 1, 0}, {0, 1, 1, 0}, {0, 0, 1, 0}, {0, 0, 0, 0}, {1, 1, 0, 1}};
        visited = new boolean[area.length][area[0].length];
        findIslands(area);
    }

    private static void findIslands(int[][] area) {
        int count = 0;
        for (int i = 0; i < area.length; i++) {
            for (int j = 0; j < area[0].length; j++) {
               int onescount =  fetch1s(i,j,area,0);
               if(onescount>0) {
                   count++;
               }
            }
        }
        System.out.println(count);
    }

    private static int fetch1s(int i, int j, int[][] area, int count1) {
        if(i<0||j<0||i>=area.length||j>=area[0].length) return 0;

        if(area[i][j]==0) {
            return 0;
        }
        else {
            count1++;
            if(visited[i][j]) {
               return 1;
            }
            visited[i][j] = true;
            fetch1s(i+1,j,area,count1);
            fetch1s(i,j+1,area,count1);
            fetch1s(i+1,j+1,area,count1);
            fetch1s(i-1,j+1,area,count1);
            fetch1s(i-1,j,area,count1);
            fetch1s(i-1,j-1,area,count1);
            fetch1s(i,j-1,area,count1);
            fetch1s(i+1,j-1,area,count1);
        }

        return count1;
    }
}
