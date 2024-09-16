package org.dsa.topics.searching.SELF;

public class FindElementInRotatedSortedArray {

    //https://leetcode.com/problems/search-in-rotated-sorted-array/
    public static void main(String[] args) {
        int[] arr = {1};
        //    int[] arr = {1};
    //    int[] arr = {1};
        int target = 1;

        System.out.println(search(arr,target));
    }
    public static int search(int[] arr, int target) {
        int findPointOfRotation = binarysearchII(arr);
        if(arr[findPointOfRotation]==target) return findPointOfRotation;
        else if(target> arr[findPointOfRotation] && target<=arr[arr.length-1]) {
            return binarysearch(arr,target,findPointOfRotation+1,arr.length-1);
        }
        else if(target>arr[findPointOfRotation] && target>=arr[0]) {
            return binarysearch(arr,target,0,findPointOfRotation-1);
        }
        else if(findPointOfRotation==0) {
            return binarysearch(arr,target,0,arr.length-1);
        }
        return -1;

    }

    public static int binarysearchII(int[] arr) {
        if(arr.length==0) return 0;
        int low = 0;
        int n = arr.length;
        int high = n-1;
        int mid = -1;
        while (low<=high){
            mid=(low+high)/2;
            int prevIndex = (mid+n-1)%n;
            int nextIndex = (mid+1)%n;
             nextIndex = (mid+1)%n;
             prevIndex = (mid+n-1)%n;
            if(arr[mid]<arr[nextIndex] && arr[mid]<arr[prevIndex]) {
              //  return mid==n-1? 0:mid;
                return mid;
            }
            else if(arr[mid]>=arr[0]) {
                low=mid+1;
            }
            else if(arr[mid]<=arr[n-1]) {
                high=mid-1;
            }
        }
        return mid==n-1? 0:mid;
    }

        public static int binarysearch(int[] arr, int target,int low,int high) {
        int n = arr.length;
        int result = -1;

        while (low<=high){
            int mid=(low+high)/2;
            if(arr[mid]==target) return mid;
            else if(arr[mid]>target) {
                high=mid-1;
            }
            else if(arr[mid]<target) {
                low=mid+1;
            }
        }
        return result;
    }
}
