package com.zly.yitukeji_20230921;

import javax.sound.midi.Soundbank;
import java.util.*;

/**
 * @author : zhaoliyang
 * @description :
 * @createDate : 2023/9/21 19:00
 */
class res{
    String key;
    int val;
    public res(String res, int val){
        this.key = key;
        this.val = val;
    }
}
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] words = scanner.nextLine().toCharArray();
        Map<Character, Integer> hashmap = new HashMap<>();
        for(char ch : words){
            if(ch >= 'a' && ch <= 'z'){
                Character key = Character.valueOf(ch);
                hashmap.put(key, hashmap.getOrDefault(key, 0) + 1);
            }
        }
        Map<Integer, List<Character>> map = new TreeMap<>();
        for(Map.Entry<Character, Integer> entry : hashmap.entrySet()){
            List<Character> list = map.containsKey(entry.getValue()) ? map.get(entry.getValue()) : new ArrayList<>();
            list.add(entry.getKey());
            map.put(entry.getValue(), list);
        }
        List<res> ans = new ArrayList<>(map.size());
        Character[] strs = new Character[map.size()];
        if(map.size() <= 1){
            System.out.println("ERROR");
            return;
        }else{
            int l = map.size() - 1;
            for(Map.Entry<Integer, List<Character>> entry : map.entrySet()){
                l--;
                List<Character> keys = entry.getValue();

                strs[l] = keys.get(0);
                if(l == 0) {
                    System.out.println(keys.get(0) + "-" + entry.getKey().intValue());
                    return;
                }

            }
        }
    }
}
