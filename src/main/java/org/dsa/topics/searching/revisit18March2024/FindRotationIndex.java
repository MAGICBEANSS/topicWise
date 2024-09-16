package org.dsa.topics.searching.revisit18March2024;

public class FindRotationIndex {


    public static void main(String[] args) {
      //  int[] arr = {2,3,4,5,9,11};
        int[] arr = {15, 18, 2, 3, 6, 12};
        int rotationNo = findMin(arr);
        System.out.println("rotationNo="+rotationNo);
    }

    /**
     * If we say array is rotated sorted , it means we have some element
     * which is less than both its neighbour
     *
     * i.e. arr[rotationIndex] < arr[rotationIndex+1] && arr[rotationIndex] < arr[rotationIndex-1]
     *  it means around rotationIndex array is not properly sorted and it happens only once
     * We intend to find this rotationIndex
     *
     * for any value of mid = (low+high/2);
     * It partitions array into two part
     * if(arr[mid]>arr[0]) then it means left subarray is sorted [15,18,19,20,22,1,2]
     *          here low = 0 , high = n-1 => 7-1 = 6;
     *          mid = 3; arr[mid] =20
     *          Now arr[mid]>arr[0] as 20>15
     *          so left subarray i.e. [15,18,19,20] is sorted.
     *          low = mid+1; i.e. 4, high = 6
     *          so we need to look on other side i.e [22,1,2] with mid = 5
     *          as arr[mid] i.e. arr[5]<arr[5+1] and arr[mid]<arr[5-1]
     *          so mid is the rotation index
     *
     *
     *
     * if(arr[mid]<arr[lastIndex]) then it means right subarray is sorted
     *          for e.g for [15, 18,19, 1,2, 3, 6, 12,13] there are 9 elements ,
     *          low = 0; high = n-1 => 9-1 = 8
     *          mid = 4 , arr[mid] = 2;
     *          Now arr[mid]<arr[lastIndex] as 2<13
     *          It means right subarray {2,3,6,12,13} is sorted
     *          so we cannot find unsorted elements annywhere here ,
     *          we have to look on other part
     *          i.e. high = mid-1 i.e. 3
     * Now other part is [15, 18,19, 1]   with low=0,high =3
     *          here mid = 1, arr[mid] = 18,
     *          Now [18]>arr[0] , so [0...mid] is sorted i.e LHS is sorted
     *          Now again we have to move on RHS ie.
     *          low = mid+1=> 2, high = 3,
     *          mid = 2;
     *          Now as arr[mid] i.e. arr[2]<arr[2+1] and arr[2]<arr[2-1]
     *      *          so mid is the rotation index
     *
     * @param arr
     * @param
     * @return
     */


    public static int findMin(int[] arr) {
        int length = arr.length;
        if(length==1) return arr[0];
        int high = length-1;
        int n = length-1;
        int low = 0;
        int mid = (low+high)/2;
        boolean solFound = false;
        while (low<=high && !solFound) {
            mid = (low+high)/2;
            int nextIndex = (mid+1)%n;
            int prevIndex = (mid+n-1)%n;
            if(arr[mid]<arr[prevIndex] && arr[mid]<arr[nextIndex]) {
                return arr[mid];
            }
            else if(arr[mid]<arr[n]) {
                // we are after rotation , so search on lhs
                high = mid-1;
            }
            else {
                low=mid+1;
            }

        }
        return arr[0];
    }


}
