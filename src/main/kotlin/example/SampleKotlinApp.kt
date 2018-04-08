package example

import com.almasb.topn.BarChartView
import com.almasb.topn.Model
import javafx.application.Application
import javafx.scene.Scene
import javafx.stage.Stage

/**
 * @author Almas Baimagambetov (almaslvl@gmail.com)
 */
class SampleKotlinApp : Application() {

    override fun start(stage: Stage) {

        // this gives top N used words in a file
        val model = Model(FileSource("LICENSE"))

        val view = BarChartView(model)

        stage.scene = Scene(view.root)
        stage.show()
    }
}

fun main(args: Array<String>) {
    Application.launch(SampleKotlinApp::class.java, *args)
}