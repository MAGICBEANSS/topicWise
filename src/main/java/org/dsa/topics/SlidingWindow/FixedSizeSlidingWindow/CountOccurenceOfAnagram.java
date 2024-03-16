package org.dsa.topics.SlidingWindow.FixedSizeSlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class CountOccurenceOfAnagram {

    //https://www.geeksforgeeks.org/problems/count-occurences-of-anagrams5839/1

    public static void main(String[] args) {
       /* String str = "forxxorfxdofr";
        String pattern = "for";*/
        String str = "aabaabaa";
        String pattern = "aaba";
      //  int z =  search(str,pattern);
        int z =  search(pattern,str);
        System.out.println(z);
    }

    static boolean compareMaps(Map<Character,Integer> original,Map<Character,Integer> current) {
        for (Character c: current.keySet()) {
            if(!original.containsKey(c) || original.get(c)!=current.get(c)) return false;
        }
        return true;
    }

    static int search(String str, String pat) {
        // code here
        if(pat.length()>str.length()) {
            String dummy = str;
            str = pat;
            pat = dummy;
        }
        int countOfAnagrams = 0;
        int n = str.length();
        Map<Character,Integer> original = new HashMap<>();
        Map<Character,Integer> current = new HashMap<>();
        int wl = pat.length();
        int k = wl;
        int j =0;
        for(j=0;j<wl;j++) {
            int count = original.getOrDefault(pat.charAt(j),0);
            original.put(pat.charAt(j),count+1);
        }
       // System.out.println(original);
        for(j=0;j<wl;j++) {
            int count = current.getOrDefault(str.charAt(j),0);
            current.put(str.charAt(j),count+1);
        }
        if(compareMaps(original,current)) {
            countOfAnagrams++;
        }
        for (j = wl; j < n; j++) {
            int outGoingIndex = j-k;
            Character outGoingChar = str.charAt(outGoingIndex);
            int i = j-k+1;
            int outgoingcharcount = current.getOrDefault(outGoingChar,0);
            if(outgoingcharcount==0) {
                // this is bug
                // since this is outgoing , so should have  been in map with at least 1 as count
                System.out.println("====BUGGGGGGA=====");
            }
            else {
                if(outgoingcharcount==1) {
                    current.remove(outGoingChar);
                }
                else {
                    current.put(outGoingChar, outgoingcharcount - 1);
                }
            }
            Character ch = str.charAt(j);
            int currentCharacterCount = current.getOrDefault(ch,0);
            current.put(ch,currentCharacterCount+1);
            boolean isAnagram = compareMaps(original,current);
            if(isAnagram) {
                countOfAnagrams++;
            }
        }
        return countOfAnagrams;



    }
}
