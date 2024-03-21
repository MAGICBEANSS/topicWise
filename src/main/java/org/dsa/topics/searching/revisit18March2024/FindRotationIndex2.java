package org.dsa.topics.searching.revisit18March2024;

public class FindRotationIndex2 {

//https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/
    public static void main(String[] args) {
        //int[] arr = {4,5,6,7,0,1,2};
     //   int[] arr = {2,2,2,0,1};
        int[] arr = {3,1,1,1};
        int rotationIndex = findRotationIndexUsingBinarySearch(arr,arr.length);
        System.out.println("rotationIndex="+rotationIndex);
    }

    /**
     *              int nextIndex = (mid+1)%n;
     *              int prevIndex = (mid+n-1)%n;
     * @param arr
     * @param length
     * @return
     */

    //Revisit this later
    private static int findRotationIndexUsingBinarySearch(int[] arr, int length) {
        if(length==1) return 0;
        if(length==2) return arr[1]>arr[0] ? 0 : 1;
        int high = length-1;
        int n = length-1;
        int low = 0;
        int mid = (low+high)/2;
        while (low<=high ) {
            mid = (low+high)/2;
            int nextIndex = (mid+1)%n;
            int prevIndex = (mid+n-1)%n;
            if(arr[mid]<arr[prevIndex] && arr[mid]<arr[nextIndex]) {
                    return mid;
                }
            else if(arr[mid]==arr[prevIndex] && arr[mid]<arr[n]) {
                high = mid-1;
            }
            else if(arr[mid]==arr[nextIndex] && arr[mid]<arr[n]) {
              //  low =
            }
                else if(arr[mid]<arr[n]) {
                    // we are after rotation , so search on lhs
                    high = mid-1;
                }
                else {
                    low=mid+1;
                }

        }
        return 0;
    }
}
