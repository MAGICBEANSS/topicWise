package org.dsa.topics.searching.revisit18March2024;

public class FindInReverseSorted {
    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1,-1};
        int index = findUsingReverseBinary(arr,arr.length,2);
        System.out.println("index="+index+" element="+arr[index]);
    }

    static int findUsingReverseBinary(int[] arr , int n,int target) {
        int high = n-1;
        int low = 0;
        int mid = (low+high)/2;
        while (low<=high) {
            mid = (low+high)/2;
            if(arr[mid]==target) {
                return mid;
            }
            else if(arr[mid]>target) {
                low = mid+1;
            }
            else {
                high = mid-1;
            }
        }
        return -1;
    }
}
