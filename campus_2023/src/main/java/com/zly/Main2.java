package com.zly;

import java.util.*;

/**
 * @author : Noone
 * @version : v1.0
 * @createTime : 2023/9/7 19:48
 * @description :
 */
public class Main2 {
    static class fun{
        String type;
        String funName;
        String[] paramsType;
        fun(String type, String funName, String[] paramsType){
            this.funName = funName;
            this.paramsType = paramsType;
            this.type = type;
        }
    }

    static fun jiexi(char[] chars){
        int left = 0, right = chars.length-1;
        for(int i = 0; i < chars.length; i++){
            if(chars[i] == '('){
                left = i;
            }
        }
        String name = "";
        String type = "";
        List<String> paramType = new ArrayList<>();
        int typeIndex = -1;
        for(int i = left-1; i >= 0; i--){
            if(chars[i] == ' '){
                typeIndex = i;
                break;
            }
            name = String.valueOf(chars[i]) + name;
        }
        if(typeIndex != -1){
            String s = chars.toString();
            for(int i = 0; i < typeIndex; i++){
                type+= chars[i];
            }
        }
        String paramsString = "";
        for(int i = left + 1; i < right; i++){
            paramsString += chars[i];
        }
//        System.out.println(paramsString);
        String[] params = paramsString.split(",");
//        System.out.println(Arrays.toString(params));
        for(String param: params){
            String[] s = param.split(" ");
            paramType.add(s[0]);
        }
//        System.out.println(Arrays.toString(paramType.toArray()));
        fun fun = new fun(type, name, paramType.toArray(new String[0]));
        return fun;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        Map<String,fun> hashmap = new HashMap<>();
        while(t-- > 0){
            int n = scanner.nextInt();
            String s1 = scanner.nextLine();
            char[] chars = scanner.nextLine().toCharArray();
            if(n == 1){
                fun f = jiexi(chars);
                if(hashmap.containsKey(f.funName)){
                    if(f.type.equals(hashmap.get(f.funName).type)){
                        System.out.println("method " + f.funName +" is already defined.");
                    }else {
                        hashmap.put(f.funName, f);
                        System.out.println("ok.");
                    }

                }else{
                    hashmap.put(f.funName, f);
                    System.out.println("ok.");
                }
            }else if(n == 2){
                fun f2 = jiexi(chars);
                boolean flag = false;
                if(!hashmap.containsKey(f2.funName)){
                    System.out.println("cannot find symbol " + f2.funName + ".");
                    continue;
                }else{
                    fun fun = hashmap.get(f2.funName);
                    System.out.println(Arrays.toString(fun.paramsType) + " " + fun.paramsType.length);
                    for (int i = 0; i < fun.paramsType.length; i++){
                        if(fun.paramsType.length != f2.paramsType.length || !fun.paramsType[i].equals(f2.paramsType[i])){
                            System.out.println("method " + f2.funName + " cannot be applied to given types.");
                            flag = true;
                            break;
                        }
                    }
                    if(!flag){
                        System.out.println("ok.");
                    }
                }

            }
        }
    }
}
