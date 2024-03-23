package org.dsa.topics.DP;

public class DPFiller {

    public static  int[][] filler(int maxi,int maxj,int valueForFirstRow,int valueForFirstCol,int defaultValue) {
        int[][] matrix = new int[maxi][maxj];
        for (int i = 0; i < maxi; i++) {
            for (int j = 0; j < maxj; j++) {
                if(j==0) {
                    matrix[i][j] = valueForFirstCol;
                }
                else if(i==0) {
                    matrix[i][j] = valueForFirstRow;
                }
                else {
                    matrix[i][j]=defaultValue;
                }
            }

        }
        return matrix;
    }
}
