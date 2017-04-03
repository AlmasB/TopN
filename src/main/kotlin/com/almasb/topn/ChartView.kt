package com.almasb.topn

import com.almasb.topn.example.FileSource
import javafx.collections.FXCollections
import javafx.collections.ObservableList
import javafx.scene.chart.BarChart
import javafx.scene.chart.CategoryAxis
import javafx.scene.chart.NumberAxis
import javafx.scene.chart.XYChart
import javafx.scene.layout.BorderPane
import javafx.scene.layout.GridPane
import tornadofx.*

class ChartView : View("TopN") {

    override val root = BorderPane()

    val model: Model = Model()

    //val items = FXCollections.observableArrayList<XYChart.Data<String, Number>>()

    init {

        with (root) {
            top {
                slider {
                    isShowTickLabels = true
                    isShowTickMarks = true

                    min = 1.0
                    value = 1.0
                    max = model.elements.size.toDouble()

                    valueChangingProperty().addListener { _, _, changing ->
                        if (!changing) {
                            center = makeChart(FXCollections.observableList(model.top(value.toInt()).map { XYChart.Data(it.name(), it.value() as Number) }))
                        }
                    }

                    valueProperty().addListener { _, _, value ->
                        if (!isValueChanging) {
                            center = makeChart(FXCollections.observableList(model.top(value.toInt()).map { XYChart.Data(it.name(), it.value() as Number) }))
                        }
                    }
                }
            }

            center {
                makeChart(FXCollections.observableArrayList())
            }
        }
    }

    private fun makeChart(items: ObservableList<XYChart.Data<String, Number>>) = barchart("Top 10 Words", CategoryAxis(), NumberAxis()) {
        series("Words") {
            data = items
        }
    }
}