package org.dsa.topics.SlidingWindow.FixedSizeSlidingWindow;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class MaxSubarrayOfSizeKDistinctElements {
//leetcode.com/problems/maximum-sum-of-distinct-subarrays-with-length-k/
    public static void main(String[] args) {
        int[] arr = {1,2,2};
        long maxsum = findMaxSumOfSubarrayWithLengthK(arr,2);
        System.out.println(maxsum);
    }

    private static long findMaxSumOfSubarrayWithLengthK(int[] arr,int k) {
        return maximumSubarraySum(arr,k);
    }

        /**
         * Since we have a condition that elements in subarray also need to be unique
         * We will maintain this using a hashset for every window of size k
         * whenever in our window we add a new element , we also remove a element from behind
         * So we will remove the outgoing element first;
         * For new element , if we see , that in set we already have that element
         * we will have to pop out that element from set, but now , there is a problem
         * suppose we have array like {1,2,3,2,4,5} and k =3
         *
         *
         * so when we encounter 2 again at index = 2 subarray is (2,3,2) , we can  see that 2 is duplicate
         * we have to remove outgoing 2 as well, in that case subarray is no longer valid ,
         * as it has only 2 elements now (..3,2), so whenever we encounter duplicate , we have to check
         * dimension/length of subarray too
         *
         *
         * There is a different possibility too, that if array is like
         * {1,3,2,2,4,5} , so now after subarray {1,3,2} when we encounter 2 i.e.
         * {3,2,2} is going to be subarray , in that case if we eleminate existing 2
         * subarray will appear like {3,.,2} "." indicates removal ,so now entire subarray until that last element
         * i.e .2 is useless , current window size is "1"
         *
         *
         * similarly lets take a bigger window to understand once more properly
         * say array is
         * {1,2,3,4,5,2} , and k =5 , so at second window of k size i.e. {2,3,4,5,2} between index {1,5}
         * here the first 2 at index 1 , will be considered duplicate and removed , thus having only 4 (k-1) elements
         * in the array, so we have to introduce new elements from right side of array
         * and we can only grow further
         *
         *
         * lets pick another array
         * {5,1,2,3,4,2} , here at second window , we encounter duplicate for first time
         * i.e .when subarray is {1,2,3,4,2}.
         * Here if we remove 2 , i.e. {1,.,3,4,2} , here window is not correct , as we had a duplicate
         * and thus removed the duplicate "2" from it/
         * point to notice is , it does not makes sense to keep "1" in the subaray as it is already discontinous
         * so if we are removing al element from subarray and also set , then we also have to
         * remove all elements from left side of it so only meaningful part of array will be {3,4,2}
         * we have to remove from index we found duplicate till j-k, i.e. until the first element
         * of the subarray
         *
         *
         *
         *
         */
        public static long maximumSubarraySum(int[] nums, int k) {
            Map<Integer,Integer> map = new HashMap<>();
        int i =0;
        int j =0;
        int n =nums.length;
        AtomicInteger sum = new AtomicInteger();
        int currentWindowSize = 0;
        AtomicInteger maxsum = new AtomicInteger();
        while(j<n) {
             i = removeoutGoingAndStarting(sum,nums,j,k,map,i);

            /*if(i>0) {
                sum=sum-nums[i-1];
            }*/
             int no = nums[j];

            if(map.containsKey(no)) {
                int duplicateIndex = map.get(no);
                int todeleteindex = duplicateIndex;
                while (todeleteindex>=0 && todeleteindex>=(j-k+1)) {
                        if(map.containsKey(nums[todeleteindex])){
                            map.remove(nums[todeleteindex]);
                           // sum = sum-nums[todeleteindex];
                            //maxsum = Math.max(sum,maxsum);
                            int xsum = sum.get();
                            xsum = xsum-nums[todeleteindex];
                            sum.set(xsum);

                        }
                        todeleteindex--;
                }
                i=duplicateIndex+1;
            }
            map.put(no,j);
            // sum=sum+no;
            sum.addAndGet(no);
            if(i>=0 && (j-i+1)==k) {
                //sum = sum - nums[j - k] + nums[j];
                int newmaxsum = Math.max(sum.get(), maxsum.get());
                maxsum.set(newmaxsum);
            }
            j++;
        }
        return maxsum.get();
    }

    private static int removeoutGoingAndStarting(AtomicInteger sum, int[] nums, int j, int k, Map<Integer, Integer> map,int i) {
        if(j-k+1<0) return -1;
        else {
             int ret = j-k+1;
            i = Math.max(ret,i);
            if(ret>0) {
                int toRemove = nums[j - k];
                if (map.containsKey(toRemove) && map.get(toRemove)<i) {

                    map.remove(toRemove);
                    int xsum = sum.get();
                    xsum = xsum-toRemove;
                    sum.set(xsum);
                }
            }
            return i;
        }
    }
}
