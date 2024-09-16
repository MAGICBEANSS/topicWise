package org.dsa.topics.searching.SELF;

public class FinfMaxInBitonicArray2 {
//https://www.callicoder.com/maximum-element-in-bitonic-array/
    //https://leetcode.com/problems/peak-index-in-a-mountain-array/
    public static void main(String[] args) {
   //     int[] arr ={1,2,3,4,5,4,3};
     //   int[] arr ={0,2, 4, 6, 8, 10};
        int[] arr ={1,3,5};
        int max = findMaxInBitonic(arr,arr.length);
        System.out.println(max);

    }

    private static int findMaxInBitonic(int[] arr, int length) {
        if(arr.length==0||arr.length==1) return 0;
        int low = 0;
        int n =length-1;
        int high = length-1;
        int mid = (low+high)/2;
        while (low<=high) {
             mid = (low+high)/2;
            if(mid>0 && mid<n && arr[mid]>arr[mid-1] && arr[mid+1]<arr[mid]) {
                return mid;
            }
            else if(mid==n || arr[mid]<arr[mid+1]){
                low=mid+1;
            }
            else if(mid>0 && arr[mid-1]>arr[mid]) {
                high=mid-1;
            }
        }
        return mid;

    }
}
