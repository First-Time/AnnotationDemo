package com.lyf.generic;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyAnnotationJavaTest {

    @MyAnnotationJava(value1 = {"a", "b"})
    @Deprecated
    public void execute() {
        System.out.println("method");
    }

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        MyAnnotationJavaTest myAnnotationJavaTest = new MyAnnotationJavaTest();
        //获取MyAnnotationJavaTest的Class实例
        Class<MyAnnotationJavaTest> c = MyAnnotationJavaTest.class;
        //获取需要处理的方法Method实例
        Method method = c.getMethod("execute", new Class[]{});
        //判断该方法是否包含MyAnnotation注解
        if (method.isAnnotationPresent(MyAnnotationJava.class)) {
            //获取该方法的MyAnnotation注解实例
            MyAnnotationJava myAnnotationJava = method.getAnnotation(MyAnnotationJava.class);
            //执行该方法
            method.invoke(myAnnotationJavaTest, new Object[]{});
            //获取MyAnnotationJava
            String[] value1 = myAnnotationJava.value1();
            for (String value : value1) {
                System.out.println(value);
            }
        }
        System.out.println();
        //获取方法上的所有注解
        Annotation[] annotations = method.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }
    }
}
