package com.almasb.topn

import com.almasb.topn.example.FileSource

/**
 *
 *
 * @author Almas Baimagambetov (almaslvl@gmail.com)
 */
class Model(val dataSource: DataSource) {

    // TODO: hardcoded
    constructor() : this(FileSource("LICENSE"))

    val elements by lazy { dataSource.elements().sortedByDescending { it.value() } }

    fun top(n: Int): List<DataElement> {
        return elements.take(n)
    }
}