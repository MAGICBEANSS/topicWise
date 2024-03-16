package org.dsa.topics.SlidingWindow.FixedSizeSlidingWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaximumInEveryWindow {
    //https://leetcode.com/problems/sliding-window-maximum/description/
    public static void main(String[] args) {
        //int[] arr = {1,3,-1,-3,5,3,6,7};
        int[] arr = {1,0};
        int k =2;
        int[] maxar = maxSlidingWindow(arr,k);
        Arrays.stream(maxar).forEach(x->{
            System.out.print(x+" ");
        });
    }

    public static int[] maxSlidingWindow(int[] arr, int k) {
        int i =0;
        int j =0;
        int n = arr.length;
        List<Integer> maxList = new ArrayList<>();
        int max = arr[0]-1;
        while (j<k) {
            if(arr[j]>max) {
                max = arr[j];
            }
            j++;
        }
        maxList.add(max);
        while (j<n) {
            int newno = arr[j];
            int backupmax = max;
            int outgoingIndex = j-k;
            if(newno>max) {
                max = newno;
            }
            if(arr[outgoingIndex]==backupmax && max==backupmax) {
                max = findNewMax(arr,j-k+1,j);
            }
            maxList.add(max);
            j++;
        }

        return maxList.stream().mapToInt(x->x).toArray();

    }

    private static int findNewMax(int[] arr, int low, int high) {
        int max = arr[low]-1;
        for (int i = low; i <= high; i++) {
            if(max<=arr[i]) max = arr[i];
        }
        return max;
    }
}
