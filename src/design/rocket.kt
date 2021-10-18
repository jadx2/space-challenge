package design

abstract class Rocket : Spaceship {
    abstract val cost: Int
    abstract val weight: Int
    abstract var currentCargo: Int
    abstract val cargoLimit: Int
    abstract val chanceToLaunch: Double
    abstract val chanceToLand: Double
    abstract override fun launch(): Boolean
    abstract override fun land(): Boolean
    abstract override fun canCarry(item: Item): Boolean
    abstract override fun carry(item: Item): Int
}
