package com.lyf.annotation;

public class AnnoJava {
    @FieldMetaJava(id = true, name = "序列号", order = 1)
    private Integer id;
    @FieldMetaJava(name = "姓名", order = 3)
    private String name;
    @FieldMetaJava(name = "年龄", order = 2)
    private Integer age;

    @FieldMetaJava(name = "描述", description = "注解描述", order = 4)
    public String desc() {
        return "Java反射获取annotation的测试";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
