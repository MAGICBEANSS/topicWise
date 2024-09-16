package org.dsa.topics.searching.SELF;

public class FindFirst1OneInfiniteSortedBinarryArray {

    //https://www.geeksforgeeks.org/find-index-first-1-infinite-sorted-array-0s-1s/
    public static void main(String[] args) {
        int[] arr = {0,0,0,0,0,0,0,1,1,1,1,1,1,1};
      //  int[] arr = {0,0,0,0,0,0,0,0,0,0,1};
        int n = arr.length;
        int k = findFirst1(arr,n);
        System.out.println(k);
    }

    private static int findFirst1(int[] arr, int n) {
        int i =0;int j =1;
        boolean found = false;
        while (arr[j]==0) {
            if(arr[j]==1) {
                found= true;
            }
            else {
                i=j;
                j=j*2;
            }
        }
        int high = j;
        int low = i;
        while (low<=high){
            int mid = (low+high)/2;
            if(arr[mid]==0) {
                low=  mid+1;
            }
            else if(arr[mid]==1){
                if(mid>0 && arr[mid-1]==0) {
                    return mid;
                }
                high=mid-1;
            }
        }
        return -1;
    }
}
