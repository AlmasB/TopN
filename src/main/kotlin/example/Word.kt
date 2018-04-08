package example

import com.almasb.topn.DataElement

/**
 * @author Almas Baimagambetov (almaslvl@gmail.com)
 */
data class Word(val title: String, val value: Int) : DataElement {

    override fun name(): String {
        return title
    }

    override fun value(): Double {
        return value.toDouble()
    }
}