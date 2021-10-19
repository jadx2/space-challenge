import design.Item
import design.U1
import design.U2
import java.io.File
import java.io.InputStream

fun main() {
  val newSimulation = Simulation()
  val items = newSimulation.loadItems("src/data/p1Data.txt")
//  println(newSimulation.loadU1(items))
  println(newSimulation.loadU2(items))
}

class Simulation {
  fun loadItems(file: String): MutableList<Item> {
    val items = mutableListOf<Item>()
    val sourceFile: InputStream = File(file).inputStream()
    val linesInText: MutableList<List<String>> = mutableListOf()
    sourceFile.bufferedReader().useLines { lines -> lines.forEach { linesInText.add(it.split("=")) } }
    for (line in linesInText) {
      val item = Item(line[0], line[1].toInt())
      items.add(item)
    }
    return items
  }

  fun loadU1(items: MutableList<Item>): MutableList<U1> {
    val u1Fleet = mutableListOf<U1>()
    var rocket = U1()
    u1Fleet.add(rocket)
    for (item in items) {
      if (rocket.canCarry(item)) {
        rocket.carry(item)
      } else {
        rocket = U1()
        u1Fleet.add(rocket)
        rocket.carry(item)
      }
    }
    return u1Fleet
  }

  fun loadU2(items: MutableList<Item>): MutableList<U2> {
    val u2Fleet = mutableListOf<U2>()
    var rocket = U2()
    u2Fleet.add(rocket)
    for (item in items) {
      if (rocket.canCarry(item)) {
        rocket.carry(item)
      } else {
        rocket = U2()
        u2Fleet.add(rocket)
        rocket.carry(item)
      }
    }
    return u2Fleet
  }
}
