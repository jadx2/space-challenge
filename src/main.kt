fun main(args: Array<String>) {
    // Create Simulation and source files
    val simulation = Simulation()
    val dataP1 = "src/data/p1Data.txt"
    val dataP2 = "src/data/p2Data.txt"

    // Load items for each phase
    val itemsP1 = simulation.loadItems(dataP1)
    val itemsP2 = simulation.loadItems(dataP2)

    // Create U1 and U2 fleet for both phases
    val u1FleetP1 = simulation.loadU1(itemsP1)
    val u1FleetP2 = simulation.loadU1(itemsP2)
    val u2FleetP1 = simulation.loadU2(itemsP1)
    val u2FleetP2 = simulation.loadU2(itemsP2)

    // Run phases
    val u1Phase1 = simulation.runSimulation(u1FleetP1)
    val u1Phase2 = simulation.runSimulation(u1FleetP2)
    val u2Phase1 = simulation.runSimulation(u2FleetP1)
    val u2Phase2 = simulation.runSimulation(u2FleetP2)

    println("Phase 1")
    println("Budget for U1: $u1Phase1")
    println("Budget for U2: $u2Phase1")
    println("-------------------------")
    println("Phase 2")
    println("Budget for U1: $u1Phase2")
    println("Budget for U2: $u2Phase2")
}
