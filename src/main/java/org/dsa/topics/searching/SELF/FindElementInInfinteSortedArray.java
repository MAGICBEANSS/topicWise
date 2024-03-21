package org.dsa.topics.searching.SELF;

public class FindElementInInfinteSortedArray {
//https://www.geeksforgeeks.org/find-position-element-sorted-array-infinite-numbers/
    //https://takeuforward.org/data-structure/search-in-an-infinite-sorted-array/

    public static void main(String[] args) {
        int arr[] = {3, 5, 7, 9, 10, 90, 100, 130,
                140, 160, 170};
        int ans = findPosInInfintearray(arr, 3);
        System.out.println(ans);

    }

    private static int findPosInInfintearray(int[] arr, int target) {
        int n = arr.length;
        int i =0;
        int j =1;
        boolean found = false;
        // find window by exponential increasing search space
        while (!found && j<n) {
            if(target>=arr[i] && target<=arr[j]) {
                found = true;
            }
            else if(target>arr[j]) {
                i=j;
                j=2*j;
            }
        }
        int high = j;
        int low=i;
        while (low<=high) {
            int mid = (low+high)/2;
            if(arr[mid]==target) return mid;
            else if(target>arr[mid]) {
                low = mid+1;
            }
            else if(target<arr[mid]) {
                high = mid-1;
            }
        }
        return -1;
    }

}
