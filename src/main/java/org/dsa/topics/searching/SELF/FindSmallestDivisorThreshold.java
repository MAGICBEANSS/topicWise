package org.dsa.topics.searching.SELF;

public class FindSmallestDivisorThreshold {


    /**
     * Just like other problems like {@link KokoEatingBananas2#minEatingSpeed(int[], int)}
     * our intuition is to find a range and
     * try using possible no out of the range to find the optimum solution
     * Again lowBound = 1;
     * So we have to divide every no by a no such that summation of this <= threshold k
     * i.e. for e.g. if array is {1,2,5,9} ,threshold = 6, say we pick a random no 3
     * Now we have to divide each element of array by 3 , get ceil from that division for each of it
     * and then add it up to get summation so it will be like
     * {ceil(1/3),ceil(2/3),ceil(5,3),ceil(9/3)} => {1,1,2,3} ==sum==> 7
     * since sum=7 > threshold (6) so 3 cannot be answer , we have to find a no such that
     * result i.e. less than threshold
     *
     * So to find a no , by dividing which we can make the solution , we intend to search in a range
     * What will be the higher bound for this
     * To get a index of higher bound , lets revisit the array
     * {1,2,5,9} , we have to minimize the summation of ceil after division
     * How can we minimize the ceil ? We can at best make it 1 .
     * (ceil of a division cannot be less than 1 unless no is 0 )
     *
     * So how can we make it 1 , by dividing the no with itself or something > itself
     * Now in array {1,2,5,9} , suppose we took 2 , then ceil(1/2) = 1 and ceil(2/2) =1
     * But what about 5,9 , ceil(5/2) = 3 which is > 1 .
     * So we have to something better.
     * What about max element , if you see , it is the largest in the array (being max obviously)
     * Now if you divide each element by max , ceil will always be 1
     * {1,2,5,9} ==> after doing ceil(no/max) => {1,1,1,1}, max=9;
     *
     * So we put highBound = max ==> 9
     * what can be the lower boumd , if clueless , we can put it to 1 (as no/0 is not defined)
     * Any how , if 1...max is too broad , it will be reduced after first iteration of binary search
     * i.e. between 1..max .So we can fix
     * low_bound = 1, high_bound = max
     *
     * Now we have to just do binary search over the range 1...Max , identify a mid ,
     * check feasibility using that mid
     * To  check the feasibility we have a method {@link #isFeasible(int[], int, int)}
     * If feasibility is not there i.e. it returns false , then it means ,
     * the sum after  ceil > threshold
     * So we need to reduce sum further , for this we need to increase the no i.e .
     * low = mid+1;
     *
     * In case if  sum after  ceil < threshold , it means that we have a possible candidate for solution
     * But since we have to find the minimum , it does not means that mid is solution ,
     * we can maybe find a smaller value and see if that could make the solution possible
     * So even if we find a solutuon , we search for a lower no
     * i.e. high = mid -1;
     *
     *

     *
     * @param args
     */
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
