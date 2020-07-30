package com.lyf.annotation;

import java.util.List;

public class AnnotationJavaTest {
    public static void main(String[] args) {
        ParentJava c = new ChildJava();
        List<SortableFieldJava> list = c.init(); //获取泛型中类里面的注解
        //输出结果
        for (SortableFieldJava field : list) {
            System.out.println("字段名称：" + (field.getField() != null ? field.getField().getName() : field.getName()) +
                    "\t\t字段类型：" + (field.getField() != null ? field.getField().getType() : field.getType()) +
                    "\t\t注解名称：" + field.getMeta().name() +
                    "\t\t注解描述：" + field.getMeta().description());
        }
    }
}
