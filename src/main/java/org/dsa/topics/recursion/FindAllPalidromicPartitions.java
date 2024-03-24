package org.dsa.topics.recursion;

import java.util.HashSet;
import java.util.Set;

public class FindAllPalidromicPartitions {


    //https://www.geeksforgeeks.org/given-a-string-print-all-possible-palindromic-partition/
    public static void main(String[] args) {
        String str = "GEEGS";
        Set<String> palindromicStrings = findPalindrome(str);
        palindromicStrings.stream().forEach(System.out::println);
    }

    private static boolean isPalindromeString(String substring) {
        StringBuilder stringBuilder = new StringBuilder(substring);
        stringBuilder = stringBuilder.reverse();
        return substring.equalsIgnoreCase(String.valueOf(stringBuilder));
    }

    private static Set<String> findPalindromes(String str, int i) {
        if(str.length()<1 || i==str.length()) {
            return new HashSet<>();
        }
        Set<String> palindromicString = new HashSet<>();
        Character ch = str.charAt(i);
        palindromicString.add(new StringBuilder().append(ch).toString());
        String partitionA = str.substring(0,i+1);
        String partitionB = str.substring(i+1);
        if(isPalindromeString(partitionA)) palindromicString.add(partitionA);
        if(isPalindromeString(partitionB)) palindromicString.add(partitionB);
        palindromicString.addAll(findPalindromes(str,i+1));
        palindromicString.addAll(findPalindromes(partitionB,0));
        return palindromicString;
    }


    //abc
    //a +"bc"
    private static Set<String> findPalindrome(String str) {
        if(str.isEmpty()){
            Set<String> list=  new HashSet<>();
            list.add("");
            return list;
        }
        String firstChar=str.charAt(0)+"";
        Set<String> fresult=findPalindrome(str.substring(1));

            if(isPalindromeString(str)) {
                fresult.add(str);

            }
            if(isPalindromeString(firstChar)) {
                fresult.add(firstChar);
            }
        return fresult;

    }
}
