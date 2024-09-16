package org.dsa.topics.searching.revisit18March2024;

public class FirstAndLastOccurence {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,5,6};
        int firstIndex = findFirstindexUsingBinarySearch(arr,arr.length,2);
        int lastIndex = findLastIndexUsingBinarySearch(arr,arr.length,2);
        System.out.println("firstIndex="+firstIndex+" lastIndex="+lastIndex);
    }

    private static int findFirstindexUsingBinarySearch(int[] arr, int length, int target) {
        int high = length-1;
        int low = 0;
        int mid = (low+high)/2;
        int firstIndex=-1;
        int lastIndex=-1;
        boolean solFound = false;
        while (low<=high && !solFound) {
            mid = (low+high)/2;
            if(arr[mid]==target) {
                if(mid==0 ) {
                  firstIndex = mid;
                    solFound = true;
                }
                else if(mid>0 && arr[mid-1]<target) {
                    firstIndex = mid;
                    solFound = true;
                }
                else if(mid>0 && arr[mid-1]==target) {
                    high = mid-1;
                }

            }
            else if(arr[mid]<target) {
                low = mid+1;
            }
            else {
                high = mid-1;
            }
        }
        return firstIndex;
    }

    private static int findLastIndexUsingBinarySearch(int[] arr, int length, int target) {
        int high = length-1;
        int low = 0;
        int mid = (low+high)/2;
        int firstIndex=-1;
        int lastIndex=-1;
        boolean solFound = false;
        while (low<=high && !solFound) {
            mid = (low+high)/2;
            if(arr[mid]==target) {
                if(mid==(length-1) ) {
                    lastIndex = mid;
                    solFound = true;
                }
                else if(mid<(length-1) && arr[mid+1]>target) {
                    lastIndex = mid;
                    solFound = true;
                }
                else if(mid<(length-1) && arr[mid+1]==target) {
                    low = mid+1;
                }

            }
            else if(arr[mid]<target) {
                low = mid+1;
            }
            else {
                high = mid-1;
            }
        }
        return lastIndex;
    }

    static int findUsingReverseBinary(int[] arr , int n,int target) {
        int high = n-1;
        int low = 0;
        int mid = (low+high)/2;
        while (low<=high) {
            mid = (low+high)/2;
            if(arr[mid]==target) {
                return mid;
            }
            else if(arr[mid]>target) {
                low = mid+1;
            }
            else {
                high = mid-1;
            }
        }
        return -1;
    }
}
