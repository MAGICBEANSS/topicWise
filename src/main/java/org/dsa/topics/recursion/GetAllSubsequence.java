package org.dsa.topics.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class GetAllSubsequence {
    //https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup
    //https://www.pepcoding.com/resources/online-java-foundation/recursion-with-arraylists/get-subsequence-official/ojquestion
    public static void main(String[] args) {
        String input = "abc";
        List<String> results = findSol(input);
        System.out.println(results);
    }

    private static List<String> findSol(String input) {
        if(Objects.isNull(input)) return null;
        if(input.length()==1) {
            return Arrays.asList("",input);
        }
        String a = input.substring(0,1);
        String b = input.substring(1,input.length());
        List<String> remaining = findSol(b);
        List<String> results = new ArrayList<>();
        for (String str: remaining) {
            results.add(new StringBuilder().append(a).append(str).toString());
            results.add(new StringBuilder().append(str).toString());
        }
        return results;
    }

}
