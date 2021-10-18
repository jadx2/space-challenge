package design

class U1: Rocket() {
    override val cost = 100000000
    override val weight = 10000
    override var currentCargo = 0
    override val cargoLimit = 8000
    override val chanceToExplodeOnLaunch = currentCargo / cargoLimit * 0.05
    override val chanceToExplodeOnLand = currentCargo / cargoLimit * 0.01
    override fun launch(): Boolean  = (0..1).random() >= chanceToExplodeOnLaunch
    override fun land(): Boolean = (0..1).random() >= chanceToExplodeOnLand
}