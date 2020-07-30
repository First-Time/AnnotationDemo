package com.lyf.generic;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class LimitBoundsDemo {
    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();
        List<? extends Number> upperToNumber = new ArrayList<>();
        List<? super Integer> downToInteger = new ArrayList<>();

        Integer integer = 1;
        Number number = new Double(2.0d);
        integerList.add(integer);
        integerList.add(null);

        for (Integer i : integerList) {
            System.out.println(i);
        }


        //<? super Integer>中的?表示Integer的某个父类型。
        //凡是Integer的变量，一定是<? super Integer>类型
        downToInteger.add(integer);

        //一个<? super Integer>类型，并不总能表示Integer，所以下一行代码无法编译
//        Integer i = downToInteger.get(0);

        //一个<? super Integer>类型总能表示为Object
        Object o = downToInteger.get(0);


        //Integer继承自Number，符合<? extends Number>定义，所以可以直接这样赋值
        upperToNumber = integerList;

//        downToInteger = integerList;

        //Integer只是<? extends Number>的一种可能，所以下一行代码无法编译
//        upperToNumber.add(integer);

        //null可以是任意类型，一定是<? extends Number>
        upperToNumber.add(null);

        //<? extends Number>类型一定可以表示为Number
        Number n = upperToNumber.get(0);


        //泛型函数使用类型上界来定义
        try {
            Method addMethod = integerList.getClass().getMethod("add", Object.class);
            addMethod.invoke(integerList, "StringValue");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        for (Object value : integerList) {
            System.out.println(value);
        }

        for (Integer i : integerList) {
            System.out.println(i);
        }
    }
}
