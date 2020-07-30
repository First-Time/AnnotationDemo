package com.lyf.annotation

class AnnoJ2K {
    @FieldMetaJ2K(id = true, name = "序列号", order = 1)
    var id = 0

    @FieldMetaJ2K(name = "姓名", order = 3)
    var name: String? = null

    @FieldMetaJ2K(name = "年龄", order = 2)
    var age = 0

    @FieldMetaJ2K(description = "描述", order = 4)
    fun desc(): String {
        return "Java反射获取annotation的测试"
    }
}