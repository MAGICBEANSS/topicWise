package org.dsa.topics.searching.revisit18March2024;

public class FindInRotatedSORTEDArray {

    /**
     *
     * We have to find a no in Sotated Sorted Array.
     * If you see problem to find rotation index ,
     * after finding the rotation index , the array is now
     * in between two  sorted parts
     * For .e.g {12,13,2,3,4,5,9,11};
     * here rotation index is 2 , arr[rotationIndex]=2
     * Now array before rotationIndex is sorted [12,13]
     * Now array after rotationIndex is sorted [2,3,4,5,9,11]
     *
     * Now we need to identify which of the two sorted array we need to find element into
     * if target is >= rotationIndex and is <= arr[lastElementofOriginalArray]
     *          then element is on right sorted array ie.  [2,3,4,5,9,11]
     * else if element is  >= rotationIndex but is < arr[0]
     *          then element is on left sorted array ie.  [12,13]
     *
     * @param args
     */
    public static void main(String[] args) {
        //  int[] arr = {2,3,4,5,9,11};
        int[] arr = {15};
        int target = 15;
        System.out.println(search(arr,target));
    }

    public static int search(int[] arr, int target) {
        int rotatedindex = findRotatedIndex(arr,arr.length);
        if(rotatedindex==-1) return -1;
        else {
            if(arr[rotatedindex]==target) return rotatedindex;
            else if(target>arr[rotatedindex] && target>arr[arr.length-1]) {
                return binarySearch(arr,0,rotatedindex-1,target);
            }
             else   return binarySearch(arr,rotatedindex+1,arr.length-1,target);
        }
    }

    private static int binarySearch(int[] arr, int low, int high, int target) {
        int n = arr.length-1;
        while (low<=high) {
            int mid = (low+high)/2;
            if(arr[mid]==target) {
                return mid;
            }
            else if(target>arr[mid]) {
                low = mid+1;
            }
            else {
                high = mid-1;
            }
        }
        return -1;
    }

    private static int findRotatedIndex(int[] arr, int length) {
        int i =0;
        if(length==1) return 0;
        if(length==0) return -1;
       int n = length-1;
       int high = n;
       int low =0;
       while(low<=high) {
           int mid = (low+high)/2;
           int nextIndex = (mid+1)%n;
           int prevIndex = (mid+n-1)%n;
           if(arr[nextIndex]>arr[mid] && arr[prevIndex]>arr[mid]) {
               return mid;
           }
           else if(arr[mid]<arr[n]) {
               high =mid-1;
           }
           else {
               low=mid+1;
           }

       }
       return 0;
    }
}
