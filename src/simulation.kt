import design.Item
import design.U1
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.URL

fun main() {
    val newSimulation = Simulation()
    val items = newSimulation.loadItems("https://s3.amazonaws.com/video.udacity-data.com/topher/2017/December/5a372d67_phase-1/phase-1.txt")
    newSimulation.loadU1(items)
}

class Simulation {
    fun loadItems(url: String): MutableList<Item> {
        val items = mutableListOf<Item>()
        val text = BufferedReader(InputStreamReader(URL(url).openStream()))
        val linesInText: MutableList<List<String>> = mutableListOf()

        text.forEachLine { linesInText.add(it.split("=")) }

        for (line in linesInText) {
            val item = Item(line[0], line[1].toInt())
            items.add(item)
        }

        return items
    }

    fun loadU1(items: MutableList<Item>) : MutableList<U1> {
        val u1Fleet = mutableListOf<U1>()
        print(items)
        return u1Fleet
    }
}