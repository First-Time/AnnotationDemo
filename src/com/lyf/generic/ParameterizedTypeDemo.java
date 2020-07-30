package com.lyf.generic;

import java.lang.reflect.*;

public class ParameterizedTypeDemo {
    public static void main(String[] args) throws Exception {
        //参数化类型通过函数返回值被外部类引用
        Method method0 = FieldT.class.getMethod("getString", Integer.class, String.class);
        Type genericReturnType0 = method0.getGenericReturnType();
        Type returnType0 = method0.getReturnType();
        Type[] genericParameterTypes0 = method0.getGenericParameterTypes();
        Type[] parameterTypes0 = method0.getParameterTypes();
        if (genericReturnType0 instanceof ParameterizedType) {
            ParameterizedType type = (ParameterizedType) genericReturnType0;
            Type[] typeArguments = type.getActualTypeArguments();
            for (Type typeArgument : typeArguments) {
                System.out.println("typeArgument = " + typeArgument);
                Class typeArgClass = (Class) typeArgument;
                System.out.println("typeArgClass = " + typeArgClass);
            }
        }
        System.out.println();

        //参数化类型通过函数参数被外部类引用
        Method method1 = FieldT.class.getMethod("get", WithT.class);
        Type genericReturnType1 = method1.getGenericReturnType();
        Type returnType1 = method1.getReturnType();
        Type[] genericParameterTypes1 = method1.getGenericParameterTypes();
        Type[] parameterTypes1 = method1.getParameterTypes();
        for (Type genericParameterType : genericParameterTypes1) {
            if (genericParameterType instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) genericParameterType;
                Type[] parameterArgTypes = parameterizedType.getActualTypeArguments();
                for (Type parameterArgType : parameterArgTypes) {
                    System.out.println("parameterArgType = " + parameterArgType);
                    Class parameterArgClass = (Class) parameterArgType;
                    System.out.println("parameterArgCLass = " + parameterArgClass);
                }
            }
        }
        System.out.println();

        //参数化类型通过字段被外部类引用
        Field field = FieldT.class.getField("withT");
        Type genericFieldType = field.getGenericType();
        Type fieldType2 = field.getType();
        if (genericFieldType instanceof ParameterizedType) {
            ParameterizedType fieldParameterizedType = (ParameterizedType) genericFieldType;
            Type[] fieldArgTypes = fieldParameterizedType.getActualTypeArguments();
            for (Type fieldArgType : fieldArgTypes) {
                System.out.println("fieldArgType = " + fieldArgType);
                Class fieldArgClass = (Class) fieldArgType;
                System.out.println("fieldArgClass = " + fieldArgClass);
            }
        }
        System.out.println();

        //参数化类型通过继承被外部类引用
        Type genericSuper = Child.class.getGenericSuperclass();
        Type superClass = Child.class.getSuperclass();
        AnnotatedType annotatedType = Child.class.getAnnotatedSuperclass();
        if (genericSuper instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) genericSuper;
            Type[] fieldArgTypes = parameterizedType.getActualTypeArguments();
            for (Type fieldArgType : fieldArgTypes) {
                System.out.println("fieldArgType = " + fieldArgType);
                Class fieldArgClass = (Class) fieldArgType;
                System.out.println("fieldArgClass = " + fieldArgClass);
            }
        }
    }
}

class WithT<T> {
}

class Child extends WithT<Integer> {

}

class FieldT {
    public WithT<Integer> withT;

    public void get(WithT<Boolean> withT) {

    }

    public WithT<String> getString(Integer integer, String str) {
        return null;
    }
}
