package com.almasb.topn

/**
 * Defines a single element from data source.
 *
 * @author Almas Baimagambetov (almaslvl@gmail.com)
 */
interface DataElement {

    /**
     * User-friendly name.
     */
    fun name(): String

    /**
     * Numerical representation.
     */
    fun value(): Double
}