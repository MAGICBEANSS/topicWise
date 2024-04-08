package org.dsa.topics.mcm;

import java.util.*;

public class FindPunishmentinteger {
    private static Set<Integer>  punishNoSet = new HashSet<>();
    private static Set<Integer>  NotpunishNoSet = new HashSet<>();
    private static int[][] dp;

    ;

    public static void main(String[] args) {
        int z = 464;
      //  int[] arr = {2,0,2,5};
        System.out.println(punishmentNumber(z));
      //  String ss = "2025";
     //   System.out.println(isSumPossibleString(ss,0,ss.length(),45));
    }

    public static int punishmentNumber(int n) {
        punishNoSet.add(1);
        List<Integer> squared= new ArrayList<>();
        List<Integer> list= new ArrayList<>();
        List<Integer> sol= new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            int x = i*i;
            list.add(i);
            squared.add(x);
        }
        int x = 0;
        sol.add(1);
        x+=1;
        for (int i = 2; i < squared.size(); i++) {
            int no = list.get(i);
            int square = squared.get(i);
            if(punishNoSet.contains(square)) {
                System.out.println("Already calculated  for i="+i);
                x+=square;
                continue;
            }
            if(NotpunishNoSet.contains(square)) {
                System.out.println("Not calculating for i="+i);
                continue;
            }

            if(square==no) {
                x+=square;
                sol.add(no);
                punishNoSet.add(square);
                continue;
            }

        //    int[] arr = getDigitArrFromNo(square);
            String ss = String.valueOf(square);
            dp = new int[8][1000];
            finitDP(dp);
            if(isSumPossibleString(String.valueOf(square),0,ss.length(),no)){
                x+=square;
                punishNoSet.add(square);
                sol.add(no);
            }
            else {
                NotpunishNoSet.add(square);
            }

        }
        return x;
    }

    private static void finitDP(int[][] dp) {
        for (int i = 0; i < dp.length; i++) {
                Arrays.fill(dp[i],-1);
            }
        }



    private static boolean isSumPossibleString(String no, int i, int j,int toGet) {

        if (toGet == 0 && Objects.equals(no, "")) return true;
        if (toGet < 0) return false;
        if(dp[i][toGet]!=-1) {
            System.out.println("NOT RESOLVING");
            return dp[i][toGet] == 1;
        }

        boolean matchFound = false;
        for (int k = i+1; k <= j; k++) {
            String leftSs = no.substring(i,k);
            int left = leftSs.isEmpty() ? 0:Integer.parseInt(leftSs);
            String right = no.substring(k,j);
            boolean isSumPossibleFromRightSubarray = isSumPossibleString(right,0,right.length(),toGet-left);
            matchFound = matchFound | isSumPossibleFromRightSubarray;
            if(matchFound) {
                break;
            }
        }
        int state = matchFound ? 1 : 0;
        dp[i][toGet] = state;
        return matchFound;
    }

    /*
    private static boolean isSumPossible(int no, int[] arr, int i, int j,int toGet) {

        if(i==(j-1) ) {
            if (toGet == arr[i]) {
            return true;
            }
        else {
            return false;
        }
        }
        if(i>=j ) {
            if(toGet == 0) {
                return true;
            }
            return false;
        }
        if(toGet<0) {
            return false;
        }
        if(Objects.nonNull(dp[i+1][j+1][toGet])) {
            System.out.println("NOT RESOLVING");
            return dp[i+1][j+1][toGet];
        }

        boolean matchFound = false;
        for (int k = i+1; k <= j; k++) {
                int current = getAppendedValue(arr,i,k-1);
                boolean isSumPossibleFromRightSubarray = isSumPossible(no,arr,k,j,toGet-current);
                matchFound = matchFound | isSumPossibleFromRightSubarray;
                if(matchFound) {
                    break;
                }
        }
        dp[i+1][j+1][toGet] = matchFound;
        return matchFound;
    }

    public static int getAppendedValue(int[] arr, int i, int j) {
        StringBuilder sb = new StringBuilder();
        for (int k = i; k <= j; k++) {
            sb.append(arr[k]);
        }
        String s = sb.toString();
        if(s.isEmpty()) return 0;
        return Integer.parseInt(sb.toString());
    }

    private static int[] getDigitArrFromNo(int no) {
        String numStr = String.valueOf(no);
        int[] digitArray = new int[numStr.length()];
        for (int i = 0; i < numStr.length(); i++) {
            digitArray[i] = numStr.charAt(i) - '0';
        }
        return digitArray;
    }

     */
}
