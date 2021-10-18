package design

class U2: Rocket() {
    override val cost = 120000000
    override val weight = 18000
    override var currentCargo = 0
    override val cargoLimit = 11000
    override val chanceToExplodeOnLaunch = currentCargo / cargoLimit * 0.04
    override val chanceToExplodeOnLand = currentCargo / cargoLimit * 0.08
    override fun launch(): Boolean  = (0..1).random() >= chanceToExplodeOnLaunch
    override fun land(): Boolean = (0..1).random() >= chanceToExplodeOnLand
}