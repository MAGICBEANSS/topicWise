package org.dsa.topics.searching.revisit18March2024;

public class FindFloorInSortedArray {

    /**
     * Floor of a no that exists in array is itself
     * if a no is greater than sorted array last element then last element is floor
     * if a no is smaller than sorted array first element then -1 is floor
     *
     * Idea here is to get as close to given no as possible
     * so if we are at any index say i,and if arr[i]==target , then i is the index
     *
     * so  if arr[i]>target
     *      and arr[i-1]< target , then, it means solution is i-1;
     *      or else  if that's not the case then we have to search on left of i , as arr[i]>target
     *
     *      For e.g. consider [1,5,7,9,11,13], target = 3 , here say we are at mid , i.e. mid = 2, arr[mid]=7;
     *      arr[mid-1] is 7 , which is also > target , so it means we have to search on LHS of mid ,
     *      as since arr[mid] > target so is for mid-1 , so on case 7 would have been there
     *      , it would have been on LHS
     *
     * ||y if  if arr[i]<target
     *    then to check if i is the floor , we should check if arr[i+1]> target
     *    If that's the case i is floor
     *    In case if that is not the case , i.e. arr[i+1]< taeget ,
     *    so target should have been lying on more right hand side i.e i+1, i+2...i+x , somewhere on RHS
     *    as LHS will be all smaller that arr[i] itself
     *
     *
     *
     *
     *
     * so if we are at any index say i, and arr[i]>target, it means solution is on Left Side
     *
     *
     *
     * @param args
     */
    public static void main(String[] args) {

        int[] arr = {1,2,8,10,11,12,19};
        int z = findFloor(arr,arr.length,3);
        System.out.println(z);

    }

    private static int findFloor(int[] arr, int n, int target) {
        if(n==1) return 0;
        if(target<arr[0]) return -1;
        if(target>arr[n-1]) return n-1;
        int low =0;
        int high = n-1;
        while (low<=high) {
            int mid = (low+high)/2;
            if(arr[mid]>target) {
                if(arr[mid-1]<target) {
                    return mid;
                }
                else {
                    high=mid-1;
                }
            }
            if(arr[mid]<target) {
                if(arr[mid+1]>target) {
                    return mid;
                }
                else {
                    low = mid+1;
                }
            }
        }
        return -1;

    }
}
