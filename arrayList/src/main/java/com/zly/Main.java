package com.zly;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Object> arrayList1 = new ArrayList<Object>(0);
        arrayList1.add(5);
        arrayList1.add(10);
        for(int i = 0; i < 10; ++i){
            arrayList1.add(i);
            System.out.println(getArrayListCapacity(arrayList1));
        }

        List<Object> arrayList2 = new ArrayList<Object>();
        arrayList2.add(5);

        int arrayListCapacity = getArrayListCapacity(arrayList1);
        int arrayListCapacity1 = getArrayListCapacity(arrayList2);

        System.out.println(arrayList1);
    }

    public static int getArrayListCapacity(List<?> arrayList){
        Class<ArrayList> arrayListClass = ArrayList.class;
        try{
            Field field = arrayListClass.getDeclaredField("elementData");
            field.setAccessible(true);
            Object[] objects = (Object[]) field.get(arrayList);
            return objects.length;
        } catch (Exception e){
            e.printStackTrace();
            return -1;
        }
    }
}