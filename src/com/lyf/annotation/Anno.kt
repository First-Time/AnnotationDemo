package com.lyf.annotation

class Anno {
    @FieldMeta(id = true, name = "序列号", order = 1)
    var id: Int = 0

    @FieldMeta(name = "姓名", order = 3)
    var name: String? = null

    @FieldMeta(name = "年龄", order = 2)
    var age: Int = 0

    @FieldMeta(description = "描述", order = 4)
    fun desc(): String {
        return "Java反射获取annotation的测试"
    }
}