package org.dsa.topics.searching.SELF;

public class SearchInNearlySortedArray {
//https://www.geeksforgeeks.org/search-almost-sorted-array/
    public static void main(String[] args) {
            int[] arr = {10, 3, 40, 20, 50, 80, 70};
            int length = arr.length;
            int z = solveIt(arr,arr.length,90);
        System.out.println(z);
    }

    private static int solveIt(int[] arr, int length,int target) {
        int mid = -1;
        int low = 0;
        int high = length-1;
        while (low<=high) {
             mid = (low+high)/2;
            int fi = findAroundMid(arr,mid,target);
            if(fi!=-1) {
                return fi;
            }
            else if(mid<high && target<arr[mid+1]) {
                high=mid-1;
            }
            else if(mid>0 && target>arr[mid-1]) {
                low=mid+1;
            }
        }
        return -1;
    }

    private static int findAroundMid(int[] arr, int mid, int target) {
        if(arr[mid]==target) return mid;
        if(mid-1>=0 && arr[mid-1]==target) return mid-1;
        if(mid+1<arr.length && arr[mid+1]==target) return mid+1;
        return -1;
    }
}
