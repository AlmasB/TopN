package com.almasb.topn

/**
 * @author Almas Baimagambetov (almaslvl@gmail.com)
 */
interface DataSource {

    fun elements(): Collection<DataElement>
}