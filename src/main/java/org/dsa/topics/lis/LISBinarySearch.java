package org.dsa.topics.lis;

import java.util.Arrays;
import java.util.HashMap;

public class LISBinarySearch {

    //https://youtu.be/on2hvxBXJH4?t=148
    public static void main(String[] args) {
        int[] arr = {10,9,2,5,3,7,101,18};

        System.out.println(lengthOfLIS(arr));
    }

    public static int lengthOfLIS(int[] arr) {
        int[] sorted = new int[arr.length];
        Arrays.fill(sorted,Integer.MIN_VALUE);
        sorted[0] = arr[0];
        int filledTill = 0;
        for (int i = 1; i < arr.length; i++) {
            int no = arr[i];
            if(no>sorted[filledTill]) {
                filledTill++;
                sorted[filledTill] = no;
            }
            else {
                int findPosition = findElementOrIndex(sorted,0,filledTill,arr[i]);
                //int z = sorted[findPosition];
                sorted[findPosition] =arr[i];

            }
        }
       return filledTill+1;

        }

    private static int findElementOrIndex(int[] arr , int low , int high,int target) {
        while (low<=high) {
            int mid = (low+high)/2;
            if(arr[mid]==target) return mid;
            else if(arr[mid]>target) {
                high=mid-1;
            }
            else {
                low=mid+1;
            }
        }
        return low;
    }
}
