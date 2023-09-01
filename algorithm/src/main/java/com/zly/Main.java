package com.zly;

import java.awt.dnd.DropTarget;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws Exception{
        int[] arrays = {1, 2, 3, 4};
        Integer[] x = Arrays.stream(arrays).boxed().toArray(Integer[]::new);
        int[] y = Arrays.stream(x).mapToInt(Integer::intValue).toArray();
        List<Integer> collect = Arrays.stream(arrays).boxed().collect(Collectors.toList());
        List<Integer> collect1 = Arrays.stream(x).collect(Collectors.toList());
        Integer[] integers = collect.stream().toArray(Integer[]::new);
        int[] ints = collect1.stream().mapToInt(Integer::intValue).toArray();

        Date date1 = new Date();
        Date date2 = new Date();
        List<Date> collection = new ArrayList<>();
//        collection.add(date1);
//        collection.add(date2);
//        System.out.println(Collections.min(collection));
//        System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(new Date(null)));
        collection.add(null);
        FileInputStream fileInputStream = new FileInputStream("http://s3-internal.guan-test-1.jdd-beta.local/osscspbucket/20230420/846381175813353473?response-content-disposition=attachment%3Bfilename%3D%25E5%25BC%2580%25E9%2580%259A%25E4%25BA%2591%25E7%25AD%25BE%25E6%259C%258D%25E5%258A%25A1%25E6%259A%25A8%25E7%2594%25B5%25E5%25AD%2590%25E7%25AD%25BE%25E7%25AB%25A0%25E6%258E%2588%25E6%259D%2583%25E4%25B9%25A6.pdf&response-content-encoding=UTF-8&response-content-type=application%2Fpdf&AWSAccessKeyId=DC0B91005ED34817B2C9C77C211B6B90&Expires=1690183970&Signature=IUGfE6PtWBn1E7SOF%2F%2FGJwdlNT0%3D");
        System.out.println(fileInputStream.toString());
    }
}