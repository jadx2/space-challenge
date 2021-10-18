package design

abstract class Rocket: Spaceship {
    abstract val cost: Int
    abstract val weight: Int
    abstract var currentCargo: Int
    abstract val cargoLimit: Int
    abstract val chanceToExplodeOnLaunch: Double
    abstract val chanceToExplodeOnLand: Double
    override fun launch(): Boolean = true
    override fun land(): Boolean = true
    override fun canCarry(item: Item): Boolean = item.weight + currentCargo < cargoLimit
    override fun carry(item: Item): Int = currentCargo + item.weight
}
