package org.dsa.topics.lis.lbs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestBitonicSequence {
    //https://leetcode.com/problems/longest-mountain-in-array/

    private static int[][] dp;
    private static Map<String,Integer> hp;
    private static Map<String,Integer> hp1;
    private static int[][] ldp;

    public static void main(String[] args) {
        int[] arr = {2,1,4,7,3,2,5};
       // int[] arr = {2,1,1,5,6,2,3,1};
        System.out.println(minimumMountainRemovals(arr));
    }

    public static int minimumMountainRemovals(int[] nums) {
        if(checksorted(nums)) return 0;
     //   int max = Arrays.stream(nums).max().getAsInt();
    //    dp = new int[nums.length+1][nums.length+1];
    //    ldp = new int[nums.length+1][nums.length+1];
     //   initia(dp,-1);
    //    initia(ldp,0);
        hp = new HashMap<>();
        hp1 = new HashMap<>();
        return findLISLDSLength(nums);
    }

    private static boolean checksorted(int[] arr) {
        for (int i = 1; i < arr.length-1; i++) {
            if((arr[i]>=arr[i-1] && arr[i+1]>=arr[i])||(arr[i]<=arr[i-1] && arr[i+1]<=arr[i])){
                continue;
            }
            else {
                return false;
            }
        }
        return true;
    }

    private static void initia(int[][] dp,int filler) {
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i],filler);
        }
    }

    private static int findLISLDSLength(int[] arr) {
        int prevIndex = -1;
        int prevNo =-1;
        int z = findLis(arr,0,prevIndex,0);
  //      System.out.println(z);
        return z;
    }

    private static int findLis(int[] arr, int i, int prevIndex,int countTillHere) {
        if(i>=arr.length) return 0;
        int no = arr[i];
        int countNotTakingIt = findLis(arr,i+1,prevIndex,countTillHere);
        int countTakingIt = 0;
        int countLDS = 0;
        int prevNo = prevIndex==-1? -1:arr[prevIndex];
        String key = i+","+prevIndex;
        /*if(dp[i][prevIndex+1]!=-1) {
           return dp[i][prevIndex+1] ;
        }*/
        if(hp.containsKey(key)) {
            return hp.get(key);
        }
        if(no>prevNo) {
            countTakingIt = 1+findLis(arr,i+1,i,countTillHere+1);
        }
        else {
            if( countTillHere>0 && no<prevNo) {
                countLDS = 1 + findLDS(arr, i + 1, i);
            }
        }
        int maxLCSFromHere = Math.max(countNotTakingIt,countTakingIt);

        System.out.println("Solutions from i="+i+" arr[i]="+arr[i]+" from PreviousIndex="+prevIndex+" here LIS = countNotTakingIt="+countNotTakingIt+" countTakingIt="+countTakingIt+" ,from here LDS="+countLDS);
      //  int maxLDSFromHere = countLDS;
        int z = Math.max(countLDS,maxLCSFromHere);
        //dp[i][prevIndex+1] = z;
        hp.put(key,z);
        return z;
    }

    private static int findLDS(int[] arr, int i, int prevIndex) {
        if(i>=arr.length|| prevIndex==-1) return 0;
        int no = arr[i];
        /*if(ldp[i][prevIndex+1]!=0) {
            return ldp[i][prevIndex+1] ;
        }*/
        String key = i+","+prevIndex;
        if(hp1.containsKey(key)) {
            return hp1.get(key);
        }
        int countNotTakingIt = findLDS(arr,i+1,prevIndex);
        int countTakingIt = 0;
        if(prevIndex==-1 ||   no < arr[prevIndex]) {
            countTakingIt = 1+findLDS(arr,i+1,i);
        }
        int max = Math.max(countNotTakingIt,countTakingIt);
    //    ldp[i][prevIndex+1] = max;
        hp1.put(key,max);
        return max;
    }
}
