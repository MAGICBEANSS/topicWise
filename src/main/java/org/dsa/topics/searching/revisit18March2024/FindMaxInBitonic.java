package org.dsa.topics.searching.revisit18March2024;

public class FindMaxInBitonic {
    /**
     * Bitonic Array is something that grows first and then declines
     * So say we are at mid
     * We need to find the max , so at max wherever it will be
     * arr[mid]>arr[mid+1] and arr[mid]>arr[mid-1] , it that's the case mid is the max element , so solution found
     * Now if  that's not the case
     * So we need to find the max , where the max will be lying ?
     * At mid ,
     *      if it is a part of increasing sequence i.e. arr[mid-1] < arr[mid]<arr[mid+1]
     *      In this case all elements on RHS i.e . mid+1, mid+2.. is greater as it is increasing sequence
     *      so max will also be on RHS
     *      so we searhc on RHS i.e. towards mid+1, mid+2 and so on
     *
     *      If that is not the case . i.e. mid is sitting as part of decreasing sequence
     *      for e.g. [11,14,15,5,4,3,2,1,0]
     *      here at mid = 4, arr[mid]=4
     *      here 5>4>3>2>1>0 ,i.e. arr[mid-2]> arr[mid-1]>arr[mid]>arr[mid+1]>arr[mid+2]...
     *      its a decreasing sequence , in that case where we will find the solution
     *      definitely not down the line . we have to go back on LHS to find the element
     *
     */
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,-1-2};
        System.out.println(findMaxNoInBitonic(arr,arr.length));
    }

    private static int findMaxNoInBitonic(int[] arr, int length) {
        int low = 0;
        int n = length-1;
        int high = length-1;


        while (low<=high) {
            int mid = (low+high)/2;
            int prevIndex = (mid-1+n)%n;
            int nextIndex = (mid+1)%n;
            if(arr[mid]>arr[prevIndex] && arr[mid]>arr[nextIndex]) {
                return mid;
            }
            else  if(arr[mid]>arr[prevIndex]) {
                // increasing sequence
                low = mid+1;
            }
            else {
                high= mid-1;
            }
        }
        return -1;
    }
}
