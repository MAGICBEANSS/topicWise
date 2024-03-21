package org.dsa.topics.searching.SELF;

public class FindSmallestDivisorThreshold {

    public static void main(String[] args) {
        int[] nums = {1,2,5,9};
        int threshold = 6;
        System.out.println(smallestDivisor(nums,threshold));
    }

    public static int smallestDivisor(int[] arr, int threshold) {
        int high = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            high = Math.max(high,arr[i]);
        }
        if(!isFeasible(arr,threshold,high)) {
            return -1;
        }
        int sol = high;
        int low = 1;
        while (low<=high) {
            int mid = (low+high)/2;
            if(isFeasible(arr,threshold,mid)) {
                sol = mid;
                high = mid-1;
            }
            else {
                low = mid+1;
            }
        }
            return sol;

    }

    public static boolean isFeasible(int[] arr,int threshold, int no) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            count+=(int)Math.ceil((double) arr[i]/no);
        }
        return count<=threshold;
    }
}
