package org.dsa.topics.searching.revisit18March2024;

public class SearchInNearlySortedArray {

    /**
     * Here each element to be in sorted position , might be either at
     * position-1, position or position+1 index ideally
     *
     * So we can say that , actual element at position i could be
     * a[i],a[i+1] or a[i-1];
     * So if we apply binary search , we need to compare target with each of the three
     * , i,i+1 and i-1;
     * If target is still smaller than i,i-1 , we can shift our search space to i-2(not i-1) as we already compared with i-1 and it is not the match , so sample space is further reduced to 0..i-2,We can go with i-1 too , its just that , its unnecessary as i-1 does not have the target we already validated
     * If target is still larger than i,i+1  , we can shift our search space to i+2(not i+1) as we already compared with i+1 and it is not the match , so sample space is further reduced to i+2..n,We can go with i+1 too , its just that , its unnecessary as i+1 does not have the target we already validated
     *
     *
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = {10, 3, 40, 20, 50, 80, 70};
        int target = 70;
        int index =  searchNearlySorted(arr,arr.length,target);
        System.out.println(index);
    }

    private static int searchNearlySorted(int[] arr, int length, int target) {
            int low = 0;
            int high = length-1;
            int n = length-1;
            while (low<=high) {
                int mid = (low+high)/2;
                int prevIndex= (mid-1+n)%n;
                int nextIndex= (mid+1)%n;
                if(arr[mid]==target ){
                    return mid;
                }
                 else if(arr[prevIndex]==target){
                     return prevIndex;
                }
                 else  if(arr[nextIndex]==target) {
                    return nextIndex;
                }
                 else if(target<arr[prevIndex]) {
                     high = mid-1;
                }
                 else {
                     low = mid+1;
                }
            }
            return -1;
    }
}
