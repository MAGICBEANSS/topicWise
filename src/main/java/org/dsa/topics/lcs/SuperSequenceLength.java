package org.dsa.topics.lcs;

import java.util.Arrays;

public class SuperSequenceLength {

    private static int[][] memo;
    public static void main(String[] args) {
        String s = "geek";
        String t = "eke";
       // int len = findLCS(s,t,s.length()-1,t.length()-1);
        System.out.println(solveSuperSequenceLength(s,t));
    }

    private static int solveSuperSequenceLength(String s,String t){
        memo = new int[s.length()+1][t.length()+1];
        initTable(memo);
        int x= findLCSMemo(s,t,s.length()-1,t.length()-1);
        int lcs_length = memo[s.length()-1][t.length()-1];
        return s.length()+t.length()-lcs_length;
    }


    private static int findLCSMemo(String s, String t, int i, int j) {
        if(i<0||j<0) {
            return 0;
        }
        if(memo[i][j]!=-1) {
            return memo[i][j];
        }
        if(s.charAt(i)==t.charAt(j)) {
            int x = 1+findLCSMemo(s,t,i-1,j-1);
            int z =0;
            memo[i][j] = x;
        } else {
            int x = Math.max(
                    findLCSMemo(s,t,i-1,j),
                    findLCSMemo(s,t,i,j-1)
            );
            int z =0;
             memo[i][j] = x;;
        }
        return memo[i][j];
    }
    private static int findLCS(String s, String t, int i, int j) {
        if(i<0||j<0) {
            return 0;
        }
        if(s.charAt(i)==t.charAt(j)) {
            int x = 1+findLCS(s,t,i-1,j-1);
            int z =0;
            return x;
        } else {
            int x = Math.max(
                    findLCS(s,t,i-1,j),
                    findLCS(s,t,i,j-1)
            );
            int z =0;
            return x;
        }
    }

    private static void initTable(int[][] memo) {
        for (int i = 0; i < memo.length; i++) {
            Arrays.fill(memo[i],-1);
        }
    }
}
