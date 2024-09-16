package org.dsa.topics.searching;

public class SingleElementinSortedArray {

    //https://leetcode.com/problems/single-element-in-a-sorted-array/submissions/1199354039/
    public static void main(String[] args) {
        int[] arr = {1,1,2,3,3,4,4,8,8};
      //  int[] arr = {3,3,7,7,10,11,11};
      //  int[] arr = {1};
     //     int[] arr = {1};
      //  int[] arr = {1,1,2,2,3};
        int z= singleNonDuplicate(arr);
        System.out.println(z);

    }


    public static int singleNonDuplicate(int[] arr) {
       return findNo(arr,0,arr.length-1);
    }

    static int findNo(int[] arr , int low,int high) {
        if(high<low) {
            return -1;
        }
        int mid = ((high+low)/2);
        int midNo = arr[mid];
        if(mid>=1 && arr[mid-1]==midNo) {
            int noOnLeft = (mid-1-low);
            if(noOnLeft%2==1) {
                return findNo(arr,low,mid-2);
            }
            else {
                return findNo(arr,mid+1,high);
            }
        }
        else if(mid<high && arr[mid+1]==midNo) {
            int noOnRight = (high-(mid+1));
            if(noOnRight%2==1) {
                return findNo(arr,mid+2,high);
            }
            else {
                return findNo(arr,low,mid-1);
            }
        }
        else {
            return midNo;
        }
    }
}
