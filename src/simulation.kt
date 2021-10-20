import design.Item
import design.Rocket
import design.U1
import design.U2
import java.io.File
import java.io.InputStream

class Simulation {
  fun loadItems(file: String): ArrayList<Item> {
    val items = arrayListOf<Item>()
    val sourceFile: InputStream = File(file).inputStream()
    val linesInText: ArrayList<List<String>> = arrayListOf()
    sourceFile.bufferedReader().useLines { lines -> lines.forEach { linesInText.add(it.split("=")) } }
    for (line in linesInText) {
      val item = Item(line[0], line[1].toInt())
      items.add(item)
    }
    return items
  }

  fun loadU1(items: MutableList<Item>): ArrayList<Rocket> {
    val u1Fleet = arrayListOf<Rocket>()
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

  fun loadU2(items: MutableList<Item>): ArrayList<Rocket> {
    val u2Fleet = arrayListOf<Rocket>()
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

  fun runSimulation(rockets: ArrayList<Rocket>): Int {
    var rocketCost = rockets[0].cost
    var failed = 0
    var budget = 0


    for (rocket in rockets) {
      while (!rocket.launch()) {
        rocket.launch()
        failed++
      }

      while (!rocket.land()) {
        rocket.land()
        failed++
      }
    }

    budget = rocketCost * (rockets.size + failed)
    return budget
  }
}
