package org.dsa.topics.searching;

import java.util.ArrayList;
import java.util.List;

public class FindTargetIndicesAfterSorting {

    //https://leetcode.com/problems/find-target-indices-after-sorting-array/description/
    public static void main(String[] args) {
            int[] arr = {1,2,5,2,3};
            int target = 2;
        System.out.println(targetIndices(arr,target));
    }

    public  static List<Integer> targetIndices(int[] arr, int target) {
        quickSort(arr,0,arr.length-1);
        List<Integer> solutions = findIndices(arr,target);
        return solutions;
    }

    static void  quickSort(int[] nums,int low, int high) {
        if(high<=low) return;
        int pivot = nums[high];
        int i = low-1;
        int j = i+1;
        while (j<high) {
            if(nums[j]<pivot) {
                i++;
                int no = nums[j];
                nums[j] = nums[i];
                nums[i] = no;
            }
            j++;
        }
        if(i<high) {
            int no = nums[high];
            nums[high] = nums[i + 1];
            nums[i+1] = no;
        }
        quickSort(nums,low,i);
        quickSort(nums,i+2,high);

    }

    private static List<Integer> findIndices(int[] arr, int target) {
        int low = 0;
        int high = arr.length-1;
        int mid = (low+high)/2;
        List<Integer> solution = new ArrayList<>();
        boolean isFound = false;
        while (low<=high && !isFound) {
            mid = (low+high)/2;
            if(arr[mid]==target) {
                isFound = true;
            }
            else if(arr[mid]>target) {
                high = mid-1;
            }
            else {
                low = mid+1;
            }
        }
        if(isFound){
            int i =mid;
            boolean othernotfound = true;
            while (othernotfound && i>=0) {
                if(arr[i]!= target) {
                    othernotfound = false;
                }
                i--;
            }
            i++;
            while (i<=mid) {
                if(arr[i]== target)
                    solution.add(i);
                i++;
            }
            i=mid+1;
            othernotfound = true;
            while (othernotfound && i<arr.length) {
                if(arr[i]== target) solution.add(i);
                else othernotfound = false;
                i++;
            }



        }
        return solution;
    }
}


