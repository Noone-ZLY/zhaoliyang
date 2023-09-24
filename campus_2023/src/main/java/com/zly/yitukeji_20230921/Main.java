package com.zly.yitukeji_20230921;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * @author : zhaoliyang
 * @description :
 * @createDate : 2023/9/21 18:59
 */
class Book{
    String name;
    int price;
    public Book(String name, int price){
        this.name = name;
        this.price = price;
    }
}
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Book> list = new ArrayList<>(n);
        for(int i = 0; i < n; i++){
            String name = scanner.next();
            int price = scanner.nextInt();
            list.add(new Book(name, price));
        }
        list.sort(new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.price - o2.price;
            }
        });
        list.forEach(book -> {
            System.out.println(book.name);
        });
    }
}
