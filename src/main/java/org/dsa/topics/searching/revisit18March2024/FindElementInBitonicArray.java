package org.dsa.topics.searching.revisit18March2024;

public class FindElementInBitonicArray {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,-1,-2};
        int target = 7;
        int maxIndex = findMaxNoInBitonic(arr,arr.length);
        int sol = -1;
        if(arr[0]<target&& arr[maxIndex]>=target) {
            //  search on first half i.e. incressing sequence
            sol = findBinarySearch(arr,arr.length,target,maxIndex,0);
        }
        else {
           sol=  findUsingReversedBinarySearch(arr,arr.length,target,arr.length-1,maxIndex+1);

        }
        System.out.println(sol);
    }

    private static int findUsingReversedBinarySearch(int[] arr,int length,int target,int high,int low) {

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

    private static int findMaxNoInBitonic(int[] arr, int length) {
        int low = 0;
        int n = length-1;
        int high = length-1;


        while (low<=high) {
            int mid = (low+high)/2;
            int prevIndex = (mid-1+n)%n;
            int nextIndex = (mid+1)%n;
            if(arr[mid]>arr[prevIndex] && arr[mid]>arr[nextIndex]) {
                return mid;
            }
            else  if(arr[mid]>arr[prevIndex]) {
                // increasing sequence
                low = mid+1;
            }
            else {
                high= mid-1;
            }
        }
        return -1;
    }
}
