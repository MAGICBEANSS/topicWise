package org.dsa.topics.lcs;

import java.util.Arrays;

public class MinNoOfInsertionAndDeletionToMakeStringEqual {

    //https://leetcode.com/problems/delete-operation-for-two-strings/description/


    static int[][] memo ;
    public static void main(String[] args) {
        String s = "pea";
        String t = "heap";
        System.out.println(solveIt(s,t));
    }

    private static Pair solveIt(String s, String t) {
        memo = new int[s.length()+1][t.length()+1];
         init(memo);
        int lcs_length = findLCSMemoized(s,t,s.length(),t.length());
        Pair p = new Pair();
        p.toDelete = s.length()>t.length()? s.length()-lcs_length: t.length()-lcs_length;
        p.toInsert = s.length()<t.length()? s.length()-lcs_length: t.length()-lcs_length;
        return p;
    }

    private static int findLCSMemoized(String s, String t,int i,int j){
        if(i==0||j==0) return 0;
        if(memo[i][j]!=-1) {
            return memo[i][j];
        }
        if(s.charAt(i-1)==t.charAt(j-1)) {
            memo[i][j] = 1 + findLCSMemoized(s, t, i - 1, j - 1);
        }
        else {
            memo[i][j] = Math.max(
                    findLCSMemoized(s,t,i-1,j),
                    findLCSMemoized(s,t,i,j-1)
                );
        }
        return memo[i][j];


    }

    private static void init(int[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i],-1);
        }

    }
}

class Pair{
    int toDelete ;
    int toInsert;

    @Override
    public String toString() {
        return "Sol-{" +
                "toDelete=" + toDelete +
                ", toInsert=" + toInsert +
                '}';
    }
}
