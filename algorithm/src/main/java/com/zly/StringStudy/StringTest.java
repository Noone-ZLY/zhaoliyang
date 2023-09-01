package com.zly.StringStudy;

/**
 * @author zhaoliyang9
 * @des
 * @date 2023/7/24 14:56
 **/
public class StringTest {
    public static void main(String[] args) {
        String s1 = new String("aaa");
        String s2 = new String("aaa");

        String s3 = "aaa";
        String s4 = "aaa";
        System.out.println(System.identityHashCode(s1) + " " + System.identityHashCode(s2));
        System.out.println(System.identityHashCode(s3) + " " + System.identityHashCode(s4));
        System.out.println(System.identityHashCode(new String("aaa")));
        System.out.println(System.identityHashCode("aaa"));
        System.out.println(System.identityHashCode(s1));

    }
}
