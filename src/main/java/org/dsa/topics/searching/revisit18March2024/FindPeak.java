package org.dsa.topics.searching.revisit18March2024;

public class FindPeak {

    public static void main(String[] args) {
        int[] arr = {1,2,3,1};
        System.out.println(findPeak(arr));
    }

    private static int findPeak(int[] arr) {
        int length = arr.length;
        int n =length-1;
        int low = 0;
        int high = n;
        while(low<=high) {
            int mid = (low+high)/2;
            int prevIndex = (mid-1+n)%n;
            int nextIndex = (mid+1)%n;
            if(arr[mid]>arr[prevIndex] && arr[mid]>arr[nextIndex]) {
                // this is peak
                return mid;
            }
            else if(arr[nextIndex]>arr[mid]) {
                /**
                 * since it is increasing on RHS , we know there is a solution here
                 * why ?
                 * coz if right element(mid+1) is greater , it gives me two possibilities
                 * if no next to that , i.e arr[mid+2] can be smaller than that arr[mid+1] , if that's the case
                 * its one of peak as arr[mid+1]>arr[mid] and arr[mid+1]>arr[mid+2]
                 *
                 * But what if that's not the case. i.e if arr[mid+2]>arr[mid+1]
                 * In that case arr[mid+1] is not the peak element as arr[mid+2]>arr[mid+1]
                 * But the thing to observe here is that as arr[mid+2]>arr[mid+1]
                 * now the same possibilities are open for arr[mid+2] that
                 * if arr[mid+3]<arr[mid+2] then arr[mid+2] is solution else this possibility
                 * propagates to arr[mid+3] and so on
                 * When it will stop , at the last element where there is nothing as mid+1, so if
                 * the last element is less than arr[last-1] then last-1 is peak , else
                 * as there is nothing on right of arr[last] , so last is the peak
                 *
                 * So we will always have peak on the side of mid which is increasing
                 *
                 * There is a possibility of peak on decreasing side from mid  as well . no point of denying , but
                 * there can't be as well , but  on increasing side that is certain to be peak
                 *
                 *
                 */
                low=mid+1;


            }
            else {
                high = mid-1;
            }
        }
        return -1;
    }
}
