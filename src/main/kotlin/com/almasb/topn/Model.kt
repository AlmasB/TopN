package com.almasb.topn

/**
 * @author Almas Baimagambetov (almaslvl@gmail.com)
 */
class Model(val dataSource: DataSource) {

    val elements by lazy { dataSource.elements().sortedByDescending { it.value() } }

    fun top(n: Int): List<DataElement> {
        return elements.take(n)
    }
}