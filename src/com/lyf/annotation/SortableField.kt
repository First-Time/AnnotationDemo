package com.lyf.annotation

import java.lang.reflect.Field

class SortableField(val meta: FieldMeta?, val field: Field?, val name: String?, val type: Class<*>?) {
    constructor(meta: FieldMeta, name: String, type: Class<*>?) : this(meta, null, name, type)
    constructor(meta: FieldMeta, field: Field?) : this(meta, field, null, null)
}