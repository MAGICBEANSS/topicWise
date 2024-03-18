package org.dsa.topics.SlidingWindow.variablesiSizeSlidingWindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacter {
   // https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
    public static void main(String[] args) {
        String s = "";
        int z = lengthOfLongestSubstring(s);
        System.out.println(z);
    }

    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Map<Character,Integer> IHaveIt = new HashMap<>();
        int j =0;
        int currlength =0;
        int maxLength = 0;
        int i =0;
        while (j<n) {
            Character ch = s.charAt(j);
            if(IHaveIt.containsKey(ch)) {
                /**
                 * duplicate found
                 * so we move i to from initial position to the index where it had the same ch
                 * This index we will found from map. say it is tofindIndex value
                 *
                 * now we will iterate from current position of i to tofindIndex
                 * in this process we will keep on decrementing the count of every char we found while traversing
                 * we keep on removing from current map too
                 *
                 */
                int duplicateFoundIndex = IHaveIt.get(ch);
                while (i<=duplicateFoundIndex) {
                    char chatAtI = s.charAt(i);
                    decrementOrRemove(IHaveIt,chatAtI);
                    i++;
                }
            }

            IHaveIt.put(ch,j);
            currlength = j-i+1;
            maxLength = Math.max(maxLength,currlength);
            j++;
        }

        return maxLength;
    }

    static void decrementOrRemove(Map<Character, Integer> hm, char ch) {
        int count = hm.getOrDefault(ch,1);
        if(count==1) hm.remove(ch);
        else hm.put(ch,count-1);
    }
}
