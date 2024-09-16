package org.dsa.topics.searching.SELF;

public class CeilInSortedArray {
    //https://www.geeksforgeeks.org/problems/floor-in-a-sorted-array-1587115620/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=bottom_sticky_on_article
    
    public static void main(String[] args) {
    //    long[] arr = {1,2,8,10,11,12,19};
        long[] arr = {3 ,4, 4, 7, 8, 10};
     //   long[] arr = {1};
        int z =  findCeil(arr,arr.length,5);
        System.out.println(z);
    }

    static int findCeil(long arr[], int n, long x)
    {
        if(arr[0]>x) return 0;
        if(arr[n-1]<x) return -1;
        int low= 0;
        int high = arr.length-1;
        while (low<=high){
             int mid = (high+low)/2;
            if(arr[mid]==x) {
                return mid;
            }
            else if(mid>0 && arr[mid]>x  && arr[mid-1]<x){
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
