import java.net.URL

fun main(args: Array<String>){
    val newSimulation = Simulation()
    newSimulation.loadItems("https://s3.amazonaws.com/video.udacity-data.com/topher/2017/December/5a372d67_phase-1/phase-1.txt")
}
class Simulation() {
    fun loadItems(url: String) {
        val data = URL(url).readText(Charsets.UTF_8)
    }
}