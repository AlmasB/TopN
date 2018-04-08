package com.almasb.topn

import javafx.collections.FXCollections
import javafx.collections.ObservableList
import javafx.scene.chart.CategoryAxis
import javafx.scene.chart.NumberAxis
import javafx.scene.chart.XYChart
import javafx.scene.layout.BorderPane
import tornadofx.*

/**
 * @author Almas Baimagambetov (almaslvl@gmail.com)
 */
class BarChartView
@JvmOverloads constructor(model: Model, val chartName: String = "") : View() {

    override val root = BorderPane()

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
                            center = makeChart(model.top(value.toInt()))
                        }
                    }
                }
            }

            center {
                makeChart(emptyList())
            }
        }
    }

    private fun makeChart(elements: Collection<DataElement>) = makeChart(FXCollections.observableList(
            elements.map { XYChart.Data(it.name(), it.value() as Number) }
    ))

    private fun makeChart(items: ObservableList<XYChart.Data<String, Number>>) = barchart(chartName, CategoryAxis(), NumberAxis()) {
        series("") {
            data = items
        }
    }
}