package org.dsa.topics.searching.SELF;

public class FindMinimumDifferenceFromTarget {
    //https://www.callicoder.com/minimum-difference-element-in-sorted-array/

    public static void main(String[] args) {
        int[] arr = {2, 5, 10, 12, 15};
        int target = 20;
        int z = findMinDifference(arr,arr.length,target);
        System.out.println(arr[z]);
    }

    private static int findMinDifference(int[] arr, int length, int target) {
        int floor= findFloor(arr,length,target);
        int ceil= findCeil(arr,length,target);
        return target-arr[floor]>arr[ceil]-target?ceil:floor;
    }

    private static int findCeil(int[] arr, int length, int target) {
        int high = length-1;
        int n = length-1;
        int low = 0;
        while (low<=high) {
            int mid = (low+high)/2;
            if(arr[mid]==target) return mid;
            if(mid>0 && arr[mid]>target && arr[mid-1]<target)
                return mid;
            else if(target<arr[mid]) {
                high=mid-1;
            }
            else if(target>arr[mid]) {
                low=mid+1;
            }
        }
        return -1;
    }

    private static int findFloor(int[] arr, int length, int target) {
        int high = length-1;
        int n = length-1;
        int low = 0;
        while (low<=high) {
            int mid = (low+high)/2;
            if(arr[mid]==target) return mid;
            if(mid<n && arr[mid]<target && arr[mid+1]>target) {
                return mid;
            }
            else if(mid<n && arr[mid+1]<=target){
                low = mid+1;
            }
            else if(arr[mid]>target) {
                high=mid-1;
            }
        }
        return -1;
    }
}
