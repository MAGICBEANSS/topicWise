package org.dsa.topics.recursion;

import java.util.*;

public class GetKPC {
    private static Map<Integer,String> hm  = new HashMap<>();

    //https://www.pepcoding.com/resources/online-java-foundation/recursion-with-arraylists/get-kpc-official/ojquestion
    public static void main(String[] args) {
         hm = getKeyMap();
        ArrayList<String> result = getKPC("123");
        result.stream().forEach(System.out::println);

    }

    private static Map<Integer,String> getKeyMap() {
        Map<Integer,String> hm = new HashMap<>();
        hm.put(0,",;");
        hm.put(1,"abc");
        hm.put(2,"def");
        hm.put(3,"ghi");
        hm.put(4,"jkl");
        hm.put(5,"mno");
        hm.put(6,"pqrs");
        hm.put(7,"tu");
        hm.put(8,"vwx");
        hm.put(9,"yz");
    return hm;
    }

    public static ArrayList<String> getKPC(String str) {
        if(Objects.isNull(str)) return (ArrayList<String>) Arrays.asList("");

        ArrayList<String> result = new ArrayList<>();
        if(str.length()==1) {
            String cstr = hm.get(Integer.valueOf(str));
            for (char ch: cstr.toCharArray()) {
                result.add(String.valueOf(ch));
            }
            return result;
            }
        String p1 = str.substring(0,1);
        String p2 = str.substring(1,str.length());
        ArrayList<String> remainingResult = getKPC(p2);
        String cstr = hm.get(Integer.valueOf(p1));
        for (char ch: cstr.toCharArray()) {
            for (String e: remainingResult) {
                result.add(new StringBuilder().append(ch).append(e).toString());
            }
        }
        return result;
    }
}
