package com.lyf.generic;

import java.lang.reflect.TypeVariable;

public class BoundsDemo {
    class TypeBounds<T extends Number> {

    }

    public static void main(String[] args) {
        TypeVariable[] typeVariables = TypeBounds.class.getTypeParameters();
        TypeVariable typeVariable = typeVariables[0];
        System.out.println("类型变量的符号是：" + typeVariable.getName());
        System.out.println("类型变量的上边界是：" + typeVariable.getBounds()[0]);
    }
}
