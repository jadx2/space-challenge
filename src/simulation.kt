import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.URL

fun main() {
    val newSimulation = Simulation()
    print(newSimulation.loadItems("https://s3.amazonaws.com/video.udacity-data.com/topher/2017/December/5a372d67_phase-1/phase-1.txt"))
}

class Simulation {
    fun loadItems(url: String): MutableList<Map<String, Int>> {
        val items = mutableListOf<Map<String, Int>>()
        val text = BufferedReader(InputStreamReader(URL(url).openStream()))
        val linesInText: MutableList<List<String>> = mutableListOf()

        text.forEachLine { linesInText.add(it.split("=")) }

        for (line in linesInText) {
            val itemObject = mapOf<String, Int>(line[0] to line[1].toInt())
            items.add(itemObject)
        }

        return items
    }
}