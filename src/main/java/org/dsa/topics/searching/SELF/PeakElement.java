package org.dsa.topics.searching.SELF;

public class PeakElement {
//https://leetcode.com/problems/find-peak-element/
    public static void main(String[] args) {
        int[] arr = {1,2,7,5,10,15,20};
      //  int[] arr = {};
        int n = arr.length;
        int z = findPeakElement(arr,n);
        System.out.println(z);
    }

    private static int findPeakElement(int[] arr, int n) {
        int low = 0;
        int high = n-1;
        int k =n-1;
        if(n==1) return arr[0];
        if(n==2) return Math.max(arr[0],arr[1]);

        while (low<=high) {
            int mid = (low + high) / 2;
            if (mid > 0 && mid < n - 1 && arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                return arr[mid];
            } else if (mid == 0 && mid < n - 1 && arr[mid] > arr[mid + 1]) {
                return arr[mid];
            } else if (mid == n - 1 && mid > 0 && arr[mid] > arr[mid - 1]) {
                return arr[mid];
            } else if (arr[mid + 1] > arr[mid]) {
                low = mid + 1;
            } else if (arr[mid - 1] > arr[mid]) {
                high = mid - 1;
            }
        }
            return -1;
        }
    }

