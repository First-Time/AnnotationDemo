package com.lyf.annotation;

import java.lang.reflect.Field;

public class SortableFieldJava {
    private FieldMetaJava meta;
    private Field field;
    private String name;
    private Class<?> type;

    public SortableFieldJava() {
    }

    public SortableFieldJava(FieldMetaJava meta, Field field) {
        this.meta = meta;
        this.field = field;
    }

    public SortableFieldJava(FieldMetaJava meta, String name, Class<?> type) {
        this.meta = meta;
        this.name = name;
        this.type = type;
    }

    public FieldMetaJava getMeta() {
        return meta;
    }

    public void setMeta(FieldMetaJava meta) {
        this.meta = meta;
    }

    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Class<?> getType() {
        return type;
    }

    public void setType(Class<?> type) {
        this.type = type;
    }
}
