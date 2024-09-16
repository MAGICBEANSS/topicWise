package org.dsa.topics.searching.SELF;

import java.util.Arrays;

public class KokoEatingBananas {

    //https://leetcode.com/problems/koko-eating-bananas/
/**
 * We need to find the minimum no of bananas that Koko eats per hour , such that
 * all the piles of bananas are completed within time
 *
 * A basic approach is to try using brute approach by taking value of k as 1.....sol
 * but this range is not known , till where we can find the solution
 * For .e.g if actual minimum value of k for a problem set is 50 , then we will be tring no
 * 1....50 and find the solution .This is very CPU intensive
 *
 *
 * so for optimal solution we need to fix a bound of that,
 * lets fix lower bound , what can be the lower bound?
 * Lower bound is something that can be a solution in very ideal or uniform case ,
 * where all the piles have same no of bananas
 *
 * lets keep lower bound as 1
 *
 * also regarding upper_bound , we have a condition that even after completing eating bananas
 * in a go , we cannot directly move to next pile , we have to wait
 * so if we would have allocated 100 bananas at a go , and 10 is the maximum in the pile
 * still it would have to wait for that turn to complete before going to next pile
 *
 * So that's not the better no . out of it , what we extract that , it does not makes sense to allocate
 * more than max for a pile , so that , even in one go , all the bananas in the pile
 * will be completed.
 *
 * So we need to find the exact no between low_bound and upper_bound
 *
 * We can iterate int the rang low_bound to up_bound and try calculations for each and find the solution
 * That will give me valid answer
 *
 * We can actually improve on that as well
 * if you see the range low_bound to up_bound we find that range is kind of sorted(its a range , so always sorted)
 *
 * We can pick no in bettween the range using binary search , try for that no ,  if we can consume the bananas in h time
 * then that's a possible candidate of answer , But that still not the minimum, to find the minimum
 * we need to move either on the LHS or RHS based on solution to find the minimum
 *
 * say range is [5,15]
 * mid = 10, we try for 10
 *      A)    If 10 is solution , we mark it as solution till now
 *          then we move on LHS i.e. 5-9 , find mid out of it  , and keep on trying , till we find a no such that
 *          we can make solution using that no n but not n-1
 *
 *     B)     If 10 is not the solution , we move further on RHS , coz we can't make it for 10 ,
 *     then definetely using  9..8..7 also we cannot make it out
 *
 *
 */


        public static void main(String[] args) {
              //  int[] bananasPile={30,11,23,4,20} ;
                int[] bananasPile={30} ;
           //     int[] bananasPile={3,6,7,11} ;
                int h =32;
                int sol = minEatingSpeed(bananasPile,h);
            System.out.println(sol);
        }
        public  static  int minEatingSpeed(int[] piles, int h) {
            int maxNo = Arrays.stream(piles).max().getAsInt();
            int minNo = Arrays.stream(piles).min().getAsInt();
        //    int avg = (int) Math.ceil(Arrays.stream(piles).average().getAsDouble());
        //    System.out.println("max="+maxNo+" avg="+avg);
            int solTillnow = maxNo;
            int lowbound = 1;
            int highbound = maxNo;
            while (lowbound<=highbound) {
                int mid = (lowbound+highbound)/2;
                 boolean isFeasible = checkFeasibility(piles,mid,h);
                 boolean isFeasibleFromPrevious = checkFeasibility(piles,mid-1,h);

                 if(mid==0 ||(isFeasible && !isFeasibleFromPrevious)){
                     solTillnow = mid;
                     return mid;
                 }
                 else if(isFeasibleFromPrevious){
                     highbound=mid-1;
                 }
                 else {
                     lowbound = mid+1;
                 }
            }
            return solTillnow;
        }

    private static boolean checkFeasibility(int[] piles, int canConsume,int h) {
            if(canConsume==0) return false;
            int totalCount = 0;
        for (int i = 0; i < piles.length; i++) {
            int bananas = piles[i];
            while (bananas>0) {
                totalCount++;
                bananas= bananas-canConsume;
            }
        }
            return totalCount<=h;
    }

}
