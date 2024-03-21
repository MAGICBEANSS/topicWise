package org.dsa.topics.searching;

public class BinarySearch {

    //https://leetcode.com/problems/binary-search/submissions/1199774060/

    public static void main(String[] args) {
            int[] arr = {-1,0,3,5,9,12};
            int target = 9;
        System.out.println(search(arr,9));
    }

    public static int search(int[] arr, int target) {

        int low = 0;
        int high = arr.length-1;
        int mid = (low+high)/2;
        while (low<=high ) {
            mid = (low+high)/2;
            if(arr[mid]==target) {
                return mid;
            }
            else if(arr[mid]>target) {
                high = mid-1;
            }
            else {
                low = mid+1;
            }
        }
        return -1;
    }
}
