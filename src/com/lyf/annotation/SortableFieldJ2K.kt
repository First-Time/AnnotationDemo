package com.lyf.annotation

import java.lang.reflect.Field

class SortableFieldJ2K {
    var meta: FieldMetaJ2K? = null
    var field: Field? = null
    var name: String? = null
    var type: Class<*>? = null

    constructor() {}
    constructor(meta: FieldMetaJ2K?, name: String?) {
        this.meta = meta
        this.name = name
    }

    constructor(meta: FieldMetaJ2K?, name: String?, type: Class<*>?) {
        this.meta = meta
        this.name = name
        this.type = type
    }

}