package com.almasb.topn

import javafx.application.Application
import javafx.stage.Stage
import tornadofx.App

/**
 *
 *
 * @author Almas Baimagambetov (almaslvl@gmail.com)
 */
//class TopNApp : Application() {
//
//    override fun start(stage: Stage) {
//        stage.title = "TopN"
//        stage.show()
//    }
//}

class TopNApp : App(ChartView::class)

fun main(args: Array<String>) {
    Application.launch(TopNApp::class.java, *args)
}