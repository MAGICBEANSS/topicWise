package org.dsa.topics.searching.SELF;

public class FloorInSortedArray {
    //https://www.geeksforgeeks.org/problems/floor-in-a-sorted-array-1587115620/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=bottom_sticky_on_article

    public static void main(String[] args) {
        long[] arr = {1,2,8,10,11,12,19};
        int z =  findFloor(arr,arr.length,4);
        System.out.println(z);
    }

    static int findFloor(long arr[], int n, long x)
    {
        if(arr[0]>x) return -1;
        if(arr[n-1]<x) return n-1;
        int low= 0;
        int high = arr.length-1;
        while (low<=high){
             int mid = (high+low)/2;
            if(arr[mid]==x) {
                return mid;
            }
            else if(mid>low && arr[mid]>x  && arr[mid-1]<x){
                return mid-1;
            }
            else if(mid<high && arr[mid]<x  && arr[mid+1]>x) {
                return mid;
            }
            else if(x>arr[mid]){
                low = mid+1;
            }
            else if(x<arr[mid]) {
                high = mid-1;
            }


        }
        return -1;


    }
}
