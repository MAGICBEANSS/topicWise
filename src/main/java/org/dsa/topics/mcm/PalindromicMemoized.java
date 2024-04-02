package org.dsa.topics.mcm;

import java.util.Arrays;

public class PalindromicMemoized {
    private static int[][] mat;

    public static void main(String[] args) {

        String str = "eegiicgaeadbcfacfhifdbiehbgejcaeggcgbahfcajfhjjdgj";
        System.out.println(minCut(str));
    }

    public static int minCut(String str) {

        mat = new int[str.length()][str.length()];
        initDPMatrix(mat);
        return findPossiblePartitionsMemo(str,0,str.length()-1);

    }



    private static int findPossiblePartitionsMemo(String str, int i, int j) {

        if(i>=j) {
            return 0;
        }
        if(mat[i][j]!=-1) {
            System.out.println("Not solving for i="+i+" and j="+j);
            return mat[i][j];
        }
        System.out.println("solving for i="+i+" and j="+j);
        if(isPalindrome(str.substring(i,j+1))) {
            return 0;
        }

        int count = Integer.MAX_VALUE;
        for (int k=i;k<j;k++) {
            int pcount=0;
            pcount++;// we are partitioning at k=1
            pcount = pcount+findPossiblePartitionsMemo(str,i,k);
            pcount = pcount+findPossiblePartitionsMemo(str,k+1,j);
            count = Math.min(count,pcount);
        }
        mat[i][j] = count;
        return count;

    }

    private static boolean isPalindrome(String s) {
        return s.isEmpty() || s.contentEquals(new StringBuilder(s).reverse());
    }

    private static void initDPMatrix(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            Arrays.fill(mat[i],-1);
        }
    }
}
