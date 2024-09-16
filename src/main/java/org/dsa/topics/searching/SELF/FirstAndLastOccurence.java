package org.dsa.topics.searching.SELF;

public class FirstAndLastOccurence {


    //https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
    public static void main(String[] args) {
        //int[] arr = {10,20,20,20,40,60,60,60,60,80,90};
        int[] arr = {1};
        int[] result = searchRange(arr,1);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]+" ");
        }

    }
    public static int[] searchRange(int[] nums, int target) {
        int li = searchlow(nums,nums.length,target);
        int hi = searchhigh(nums,nums.length,target);
        int[] result = new int[2];
        result[0] = li;
        result[1] = hi;
        return result;
    }

    private static int searchlow(int[] arr, int length, int target) {
        int low = 0;
        int high = length-1;
        int mid ;
        int si = length;
        while (low<=high) {
            mid= (low+high)/2;
            if(arr[mid]==target) {
                si=Math.min(si,mid);
                high=mid-1;
            }
            else if(arr[mid]<target) {
                if(mid<high && arr[mid+1]==target) si=Math.min(si,mid+1);
                low = mid+1;
            }
            else if(arr[mid]>target) {
             //   if(mid>low && arr[mid-1]==target ) li=Math.max(li,mid-1);
                high = mid-1;
            }
        }
        if(si==length) si=-1;
        return si;
    }

    private static int searchhigh(int[] arr, int length, int target) {
        int low = 0;
        int high = length-1;
        int mid ;
     //   int si = length;
        int hi = -1;
        while (low<=high ) {
            mid= (low+high)/2;
            if(arr[mid]==target) {
                hi=Math.max(hi,mid);
                low = mid+1;
            }
            else if(arr[mid]<target) {
                low = mid+1;
            }
            else if(arr[mid]>target) {
                if(mid>low && arr[mid-1]==target ) hi=Math.max(hi,mid-1);
                high = mid-1;
            }
        }
        return hi;
    }
}
