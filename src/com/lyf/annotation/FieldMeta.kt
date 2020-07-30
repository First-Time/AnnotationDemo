package com.lyf.annotation

@Retention(AnnotationRetention.RUNTIME)
@Target(
    AnnotationTarget.FIELD,
    AnnotationTarget.FUNCTION,
    AnnotationTarget.PROPERTY_GETTER,
    AnnotationTarget.PROPERTY_SETTER
)
@MustBeDocumented
annotation class FieldMeta(
    /**
     * 是否为序列号
     */
    val id: Boolean = false,
    /**
     * 字段名称
     */
    val name: String = "",
    /**
     * 是否可编辑
     */
    val editable: Boolean = true,
    /**
     * 是否在列表中显示
     */
    val summary: Boolean = true,
    /**
     * 描述字段
     */
    val description: String = "",
    /**
     * 排序字段
     */
    val order: Int = 0
) {
}