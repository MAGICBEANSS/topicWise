package org.dsa.topics.SlidingWindow.variablesiSizeSlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithKRepeatingCharacters {

    public static void main(String[] args) {
        String s = "ababbc";
        int k = 2;
        int z = longestSubstringAtLeastK(s,k);
        System.out.println(z);
    }

    public static int longestSubstringAtLeastK(String s, int k) {
        Map<Character,Integer> frequency = new HashMap<>();
        // the frequency of each character in this substring is greater than or equal to k.
        int j=0;
        int i=0;
        int n = s.length();
        int maxLength = 0;
        boolean currentState = false;
        while (j<n) {
           char ch = s.charAt(j);
           int count = frequency.getOrDefault(ch,0);

           if((k-count)==1) {
               // possible candidate for solution
               // check others using map
               // if map is balanced then turn currentState = true;
               currentState = checkMapStatus(frequency,k,ch);
               if(currentState) {
                   maxLength = Math.max(maxLength,j-i+1);
               }
               frequency.put(ch,count+1);
           }
           else if(k>count && k-count>1){
               // not a solution
               frequency.put(ch,count+1);
               currentState = false;
           }
           else {
               // i.e  count == k or count>k
               // if map is in balanced state , then it can be a soluttion too,
               // whether map is currently balanced or not depends on currentState
               if(currentState) {
                   maxLength = Math.max(maxLength,j-i+1);
               }
               frequency.put(ch,count+1);
           }

       j++; }
        return maxLength;
    }

    private static boolean checkMapStatus(Map<Character,Integer> hm, int k, char ch) {
        for (Character c: hm.keySet()) {
            if(c==ch) {
               if(hm.get(c)<(k-1)){
                   return false;
               }
            }
            else {
                if(hm.get(c)<(k)){
                    return false;
                }
            }
        }
        return true;
    }
}
