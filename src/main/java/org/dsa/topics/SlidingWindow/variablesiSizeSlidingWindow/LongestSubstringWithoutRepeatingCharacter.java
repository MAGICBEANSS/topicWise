package org.dsa.topics.SlidingWindow.variablesiSizeSlidingWindow;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacter {
   // https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
    public static void main(String[] args) {
        String s = "abcabcbb";
        int z = lengthOfLongestSubstring(s);
        System.out.println(z);
    }

    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> IHaveIt = new HashSet<>();
        int j =0;
        int currlength =0;
        int maxcount = 0;
        int i =-1;
        while (j<n) {
            Character ch = s.charAt(j);
            if(IHaveIt.contains(ch)) {
                i++;
                int outGoingIndex = i;

            }
            else {
                j++;
            }
            IHaveIt.add(ch);
            currlength = j-i+1;
            maxcount = Math.max(currlength,maxcount);
            j++;
        }
        return maxcount;
    }
}
