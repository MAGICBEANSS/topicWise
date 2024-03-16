package org.dsa.topics.searching.SELF;

public class Test {
    public static void main(String[] args) {
        int[] arr ={2,2,5,3,3};
        int result =arr[0];
        for (int i = 1; i < arr.length; i++) {
            result=result^arr[i];
            System.out.println("rn "+result);
        }
        System.out.println(result);

    }
}
