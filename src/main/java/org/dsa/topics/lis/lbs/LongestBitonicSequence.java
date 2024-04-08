package org.dsa.topics.lis.lbs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * My Idea is here to find LDS from everywhere my sequence is not increasing.
 * See , either my sequence is increasing or decreasing.
 * (In case it is not increasing or decreasing i.e. is equals, then it is not
 * important to me)
 *
 * So alongwith LCS flow , i also check for LDS in code
 *
 * //NORMAL LIS flow
 *  if(no>prevNo) {
 *             countTakingIt = 1+findLis(arr,i+1,i,countTillHere+1);
 *         }
 *         else {
 *         // LDS flow
 *             if( no<prevNo) {
 *                 countLDS = 1 + findLDS(arr, i + 1, i);
 *             }
 *         }
 *
 * Now say my arrays is {2,10,11,8,7,4,3,1}
 * Now here say at index =1 , i.e. 10
 * its increasing for now as 10>2, we can't guarantee that
 * there can be a decreasing sequence here,
 * (what if all elements after 10 are increasing ?
 * or what if there is no element after 10)
 * So we have only known possibility of increasing or sequence ending here itself.
 * So we can only have a possibility of Decreasing sequence if we get current no as less than previous
 *
 * That is why in above code
 *
 * Also very specific to Question definition of Bitonic may vary
 * Some say should must be increasing first and then must be decreasing
 * Some say its fine even if its directly decreasing or only increasing
 *
 * So for this based on question we have to alter
 *
 * For e.g. If we are considering it should be decreasing only after it was increasing , then
 * I must have a LIS of >0 from where it started decreasing . (As it must have been increasing earlier to be considered before it started decreasing)
 *
 * So that is why countTillHere>0  is being checked
 *
 *              if( countTillHere>0 && no<prevNo) {
 *                   countLDS = 1 + findLDS(arr, i + 1, i);
 *               }
 *
 *
 * If that is not the case , i.e. only increasing or only decreasing are accepted too
 * then we can remove this check of countTillHere>0
 *
 *              if( no<prevNo) {
 *  *                  countLDS = 1 + findLDS(arr, i + 1, i);
 *  *             }
 */
public class LongestBitonicSequence {

    private static int[][] dp;
    private static Map<String,Integer> hp;
    private static Map<String,Integer> hp1;
    private static int[][] ldp;

    public static void main(String[] args) {
        int[] arr = {2,1,4,7,3,2,5};
       // int[] arr = {2,1,1,5,6,2,3,1};
        System.out.println(minimumMountainRemovals(arr));
    }

    public static int minimumMountainRemovals(int[] nums) {
        if(checksorted(nums)) return 0;
     //   int max = Arrays.stream(nums).max().getAsInt();
    //    dp = new int[nums.length+1][nums.length+1];
    //    ldp = new int[nums.length+1][nums.length+1];
     //   initia(dp,-1);
    //    initia(ldp,0);
        hp = new HashMap<>();
        hp1 = new HashMap<>();
        return findLISLDSLength(nums);
    }

    private static boolean checksorted(int[] arr) {
        for (int i = 1; i < arr.length-1; i++) {
            if((arr[i]>=arr[i-1] && arr[i+1]>=arr[i])||(arr[i]<=arr[i-1] && arr[i+1]<=arr[i])){
                continue;
            }
            else {
                return false;
            }
        }
        return true;
    }

    private static void initia(int[][] dp,int filler) {
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i],filler);
        }
    }

    private static int findLISLDSLength(int[] arr) {
        int prevIndex = -1;
        int prevNo =-1;
        int z = findLis(arr,0,prevIndex,0);
  //      System.out.println(z);
        return z;
    }

    private static int findLis(int[] arr, int i, int prevIndex,int countTillHere) {
        if(i>=arr.length) return 0;
        int no = arr[i];
        int countNotTakingIt = findLis(arr,i+1,prevIndex,countTillHere);
        int countTakingIt = 0;
        int countLDS = 0;
        int prevNo = prevIndex==-1? -1:arr[prevIndex];
        String key = i+","+prevIndex;
        /*if(dp[i][prevIndex+1]!=-1) {
           return dp[i][prevIndex+1] ;
        }*/
        if(hp.containsKey(key)) {
            return hp.get(key);
        }
        if(no>prevNo) {
            countTakingIt = 1+findLis(arr,i+1,i,countTillHere+1);
        }
        else {
            if( countTillHere>0 && no<prevNo) {
                countLDS = 1 + findLDS(arr, i + 1, i);
            }
        }
        int maxLCSFromHere = Math.max(countNotTakingIt,countTakingIt);

        System.out.println("Solutions from i="+i+" arr[i]="+arr[i]+" from PreviousIndex="+prevIndex+" here LIS = countNotTakingIt="+countNotTakingIt+" countTakingIt="+countTakingIt+" ,from here LDS="+countLDS);
      //  int maxLDSFromHere = countLDS;
        int z = Math.max(countLDS,maxLCSFromHere);
        //dp[i][prevIndex+1] = z;
        hp.put(key,z);
        return z;
    }

    private static int findLDS(int[] arr, int i, int prevIndex) {
        if(i>=arr.length|| prevIndex==-1) return 0;
        int no = arr[i];
        /*if(ldp[i][prevIndex+1]!=0) {
            return ldp[i][prevIndex+1] ;
        }*/
        String key = i+","+prevIndex;
        if(hp1.containsKey(key)) {
            return hp1.get(key);
        }
        int countNotTakingIt = findLDS(arr,i+1,prevIndex);
        int countTakingIt = 0;
        if(prevIndex==-1 ||   no < arr[prevIndex]) {
            countTakingIt = 1+findLDS(arr,i+1,i);
        }
        int max = Math.max(countNotTakingIt,countTakingIt);
    //    ldp[i][prevIndex+1] = max;
        hp1.put(key,max);
        return max;
    }
}
