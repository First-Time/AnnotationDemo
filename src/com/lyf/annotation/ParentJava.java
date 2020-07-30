package com.lyf.annotation;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ParentJava<T> {
    private Class<T> entity;

    public ParentJava() {
    }

    public List<SortableFieldJava> init() {
        List<SortableFieldJava> list = new ArrayList<>();
        /**
         * getClass.getGenericSuperclass()返回此Class所表示的实体（类、接口、基本类型或void）的直接超类的Type（Class<T>泛型中的类型），
         * 然后将其转换为ParameterizedType。
         * getActualTypeArguments()返回表示此类型实际类型参数的 Type 对象的数组。
         * [0]就是这个数组中第一个了。
         * 简而言之就是获得超类的泛型参数的实际类型。
         */
        entity = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        if (entity != null) {
            /**
             * 返回类中所有字段，包括public、protected、default、private字段，但不包括继承的字段
             * entity.getFields() 只返回对象所表示的类或接口的所有可访问公共字段
             * 在class中getDeclared**()方法返回的都是所有访问权限的字段、方法等
             */
            Field[] fields = entity.getDeclaredFields();
            for (Field f : fields) {
                FieldMetaJava meta = f.getAnnotation(FieldMetaJava.class);
                if (meta != null) {
                    SortableFieldJava sf = new SortableFieldJava(meta, f);
                    list.add(sf);
                }
            }
            //返回对象所表示的类或接口的所有可访问公共方法
            Method[] methods = entity.getMethods();
            for (Method m : methods) {
                FieldMetaJava meta = m.getAnnotation(FieldMetaJava.class);
                if (meta != null) {
                    SortableFieldJava sf = new SortableFieldJava(meta, m.getName(), m.getReturnType());
                    list.add(sf);
                }
            }

            Collections.sort(list, new Comparator<SortableFieldJava>() {
                @Override
                public int compare(SortableFieldJava o1, SortableFieldJava o2) {
                    return o1.getMeta().order() - o2.getMeta().order();
                }
            });
        }
        return list;
    }
}
