package org.dsa.topics.searching.SELF;

public class CountOccureneInSortedArray {
    public static void main(String[] args) {
        //https://www.geeksforgeeks.org/problems/number-of-occurrence2259/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=bottom_sticky_on_article
        int[] arr = {10,20,20,20,40,60,60,60,60,80,90};
        int len = count(arr,arr.length,90);
        System.out.println(len);
    }

    static int count(int[] arr, int n, int x) {
        // code here
      /*  if(arr.length==1 ){
            if(arr[0]==x) return 1;
            else return 0;
        }*/
        int hi = findLastOccurence(arr,0,arr.length-1,x);
        int li = findFirstOccurence(arr,0,arr.length-1,x);


        return hi!=-1? hi-li+1:0;
    }

    private static int findLastOccurence(int[] arr, int low, int high, int target) {
        int mid = (low+high)/2;
        int hi = -1;
        while (low<=high) {
            mid = (low+high)/2;
            if(arr[mid]==target) {
                hi = Math.max(hi,mid);
                low= mid+1;
            }
            else if(target>arr[mid]) {
                low = mid+1;
            }
            else {
                high = mid-1;
            }
        }
        return hi;
    }

    private static int findFirstOccurence(int[] arr, int low, int high, int target) {
        int mid = (low+high)/2;
        int li = arr.length;
        while (low<=high) {
            mid = (low+high)/2;
            if(arr[mid]==target) {
                li = Math.min(li,mid);
                high= mid-1;
            }
            else if(target>arr[mid]) {
                low = mid+1;
            }
            else {
                high = mid-1;
            }
        }
        return li==arr.length ? -1:li;
    }
}
