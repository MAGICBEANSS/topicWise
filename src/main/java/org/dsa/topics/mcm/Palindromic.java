package org.dsa.topics.mcm;

import java.util.Arrays;

public class Palindromic {
    private static int[][] mat;

    public static void main(String[] args) {

        String str = "eegiicgaeadbcfacfhifdbiehbgejcaeggcgbahfcajfhjjdgj";
        mat = new int[str.length()][str.length()];
        initDPMatrix(mat);
        int count = findPossiblePartitions(str,0,str.length()-1);

        System.out.println(count);
    }

    private static int findPossiblePartitions(String str, int i, int j) {
        if(i>=j) {
            return 0;
        }
        if(mat[i][j]!=-1) {
            System.out.println("Not solving for i="+i+" and j="+j);
            return mat[i][j];
        }
        if(isPalindrome(str.substring(i,j+1))) {
            return 0;
        }

        int count = Integer.MAX_VALUE;
        for (int k=i;k<j;k++) {
            int pcount=0;
            String part1 = str.substring(i,k+1);
            String part2 = str.substring(k+1,j+1);
            pcount++;
            pcount = pcount+findPossiblePartitions(part1,0,part1.length()-1);
          //  pcount = pcount+findPossiblePartitions(str,i,k);
            pcount = pcount+findPossiblePartitions(part2,0,part2.length()-1);
           // pcount = pcount+findPossiblePartitions(str,k+1,j);
            count = Math.min(count,pcount);
        }
        return count;

    }


    private static int findPossiblePartitionsMemo(String str, int i, int j) {
        if(i>=j) {
            return 0;
        }
        if(mat[i][j]!=-1) {
            System.out.println("Not solving for i="+i+" and j="+j);
            return mat[i][j];
        }
        if(isPalindrome(str.substring(i,j+1))) {
            return 0;
        }

        int count = Integer.MAX_VALUE;
        for (int k=i;k<j;k++) {
            int pcount=0;
            String part1 = str.substring(i,k+1);
            String part2 = str.substring(k+1,j+1);
            pcount++;
            //  pcount = pcount+findPossiblePartitions(part1,0,part1.length()-1);
            pcount = pcount+findPossiblePartitions(str,i,k);
            //  pcount = pcount+findPossiblePartitions(part2,0,part2.length()-1);
            pcount = pcount+findPossiblePartitions(str,k+1,j);
            count = Math.min(count,pcount);
        }
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
