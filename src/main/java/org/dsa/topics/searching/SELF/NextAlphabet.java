package org.dsa.topics.searching.SELF;

public class NextAlphabet {

    //https://leetcode.com/problems/find-smallest-letter-greater-than-target/description/
    public static void main(String[] args) {
        String str = "b";
        char next = nextGreatestLetter(str.toCharArray(),'b');
        System.out.println(next);

    }

    public static char nextGreatestLetter(char[] letters, char target) {
        int low = 0;
        int high = letters.length-1;
        int n = letters.length;
        while (low<=high) {
            int mid = (low+high)/2;
            char midchar = letters[mid];
            if(mid>0 && midchar>target && letters[mid-1]<=target){
                return midchar;
            }
            else if(midchar>target) {
                high = mid-1;
            }
            else  if(midchar<=target) {
                low=mid+1;
            }
        }
        return letters[0];

    }
}
