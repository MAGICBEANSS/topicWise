package org.dsa.topics.mcm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SplitArrayLargestSumBinarySearch {
    private static Integer MAX_MIN = Integer.MAX_VALUE;
    private static Integer MAX_PARTITIONS ;
    private static Map<String,Integer> hm;


    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        int k =5;
    //    int[] nums = {2,3,1};
    //    int k =3;
        System.out.println(splitArray(nums,k));
    }

    public static int splitArray(int[] nums, int k) {
       int min = Arrays.stream(nums).min().getAsInt();
       return -1;
    //   int x
    }




    private static int solveSplitMCMI(int[] arr, int pleft, int i, int j, int totalsum) {


        if(i>j) {
            return Integer.MAX_VALUE;
        }
        String key = i+","+j+","+pleft;

        if(hm.containsKey(key)) {
            return hm.get(key);
        }
        if(pleft==0||(i==j)) {
            int sum = 0;
            for (int z = i; z <= j; z++) {
                sum+=arr[z];
            }
            return sum;
        }
        int max = Integer.MAX_VALUE;
        for (int k = i+1; k <= j; k++) {
            int sumLeft = 0;
            for (int z = i; z <k; z++) {
                sumLeft+=arr[z];
            }
            int totalsumRight = totalsum-sumLeft;
            int highestFromRight = solveSplitMCMI(arr,pleft-1,k,j,totalsumRight);
            max = Math.min(max,Math.max(sumLeft,highestFromRight));
        }
        hm.put(key,max);
        return max;


    }


}
