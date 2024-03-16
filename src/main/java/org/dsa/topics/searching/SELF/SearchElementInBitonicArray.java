package org.dsa.topics.searching.SELF;

import java.util.ArrayList;

public class SearchElementInBitonicArray {

    //https://www.interviewbit.com/problems/search-in-bitonic-array/


    public static void main(String[] args) {
        int[] arr ={0,2, 4, 6, 8, 10,3,1};
   //     int ele = findElementInBitonicSearch(arr,arr.length,4);
        int ele = solve(arrayToArrayList(arr),4);
        System.out.println(ele);
    }

    static ArrayList<Integer> arrayToArrayList(int[] arr) {
        ArrayList<Integer> arrayList = new ArrayList<>(arr.length);

        for (int value : arr) {
            arrayList.add(value);
        }

        return arrayList;
    }

    public static int solve(ArrayList<Integer> A, int B) {
        int[] arr = new int[A.size()];
       arr =  A.stream().mapToInt(x->x).toArray();
       return findElementInBitonicSearch(arr,arr.length,B);
    }

    private static int findElementInBitonicSearch(int[] arr, int length, int target) {
            int peakIndex = findPeakIndex(arr,length);
            int k =  findBinarySearch(arr,arr.length,target,peakIndex,0);
            int l =  findBinarySearchReversed(arr,arr.length,target,length-1,peakIndex);
           if(k==-1 && l!=-1) return l;
           if(l==-1 && k!=-1) return k;
           else return Math.min(k,l);
    }

    private static int findBinarySearch(int[] arr,int length,int target,int high,int low) {

        while (low<=high) {
            int mid = (low+high)/2;
            if(arr[mid]==target) {
                return mid;
            }
            else if(arr[mid]>target) {
                high=mid-1;
            }
            else if(arr[mid]<target) {
                low=mid+1;
            }
        }
        return -1;
    }

    private static int findBinarySearchReversed(int[] arr,int length,int target,int high,int low) {

        while (low<=high) {
            int mid = (low+high)/2;
            if(arr[mid]==target) {
                return mid;
            }
            else if(arr[mid]>target) {
                low=mid+1;
            }
            else if(arr[mid]<target) {
                high=mid-1;
            }
        }
        return -1;
    }

    private static int findPeakIndex(int[] arr, int length) {
        if(arr.length==0||arr.length==1) return 0;
        int low = 0;
        int high = length-1;
        int n = length-1;
        while (low<=high) {
            int mid = (high+low)/2;
            if(mid==n) return mid;
            if(mid>0 && mid<n && arr[mid]>arr[mid-1] && arr[mid]>arr[mid+1]) {
                return mid;
            }
            else if(mid<n && arr[mid]<arr[mid+1]) {
                low = mid+1;
            }
            else if(mid>0 && arr[mid-1]>arr[mid]){
                high=mid-1;
            }
        }
        return -1;

    }
}
