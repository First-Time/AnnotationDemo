package com.lyf.generic;

import java.util.ArrayList;
import java.util.List;

public class CovariantDemo {
    public static void main(String[] args) {
        Object[] objectArray = new Object[3];
        Integer[] integerArray = new Integer[3];
        objectArray = integerArray;

        List<Object> objectList = new ArrayList<>();
        List<Integer> integerList = new ArrayList<>();
        //泛型不具有协变性质
//        objectList = integerList;
        objectList.add("string value");
    }
}
