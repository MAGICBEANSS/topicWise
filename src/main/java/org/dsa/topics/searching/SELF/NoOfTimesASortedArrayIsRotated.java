package org.dsa.topics.searching.SELF;

public class NoOfTimesASortedArrayIsRotated {
    //https://takeuforward.org/arrays/find-out-how-many-times-the-array-has-been-rotated/
    //https://www.geeksforgeeks.org/problems/rotation4723/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=bottom_sticky_on_article

    public static void main(String[] args) {
    //    int arr[] = {5,6,7,8,9,10,11, 1, 2, 3, 4};
        int arr[] = {11,10};
      //  int arr[] = {66,72,79,86,95,104,106,110,119,123,124,129,132,136,137,142,150,2,12,14,17,26,30,36,38,46,52,60};
        int z = findKRotation(arr,arr.length);
        System.out.println(z);
    }

    static int findKRotation(int arr[], int n) {
    //    if(n==1) return 0;
    //    if(arr[n-1]>arr[0]) return 0;
        // code here
        int low = 0;
        int high = n-1;
        int mid=-1;
        while (low<=high) {
             mid = (low+high)/2;
             int nextIndex = (mid+1)%n;
             int prevIndex = (mid+n-1)%n;
            if( arr[prevIndex]>arr[mid] && arr[nextIndex]>arr[mid]) {
                return mid;
            }
            /*if(arr[mid-1]>arr[mid] && arr[mid+1]>arr[mid]){
                return mid;
            }*/
            else if(arr[mid]<=arr[0]){
                high=mid-1;
            }
            else if(arr[n-1]<=arr[mid]) {
                low=mid+1;
            }
        }
        return mid==n-1?0:mid;
    }
}
