package example

import com.almasb.topn.DataElement
import com.almasb.topn.DataSource
import java.nio.file.Files
import java.nio.file.Paths

/**
 * @author Almas Baimagambetov (almaslvl@gmail.com)
 */
class FileSource(val fileName: String) : DataSource {

    override fun elements(): Collection<DataElement> {
        return Files.readAllLines(Paths.get(fileName))
                // TODO: customizable
                .flatMap { it.split(" +".toRegex()).filter { it != "" }.map(String::toLowerCase) }
                .groupBy { it }
                .mapValues { it.value.size }
                .entries
                .map { Word(it.key, it.value) }
    }
}