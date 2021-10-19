package design

class U1: Rocket() {
    override val cost = 100000000
    override val weight = 10000
    override var currentCargo = 0
    override val cargoLimit = 8000
    override val chanceToExplodeOnLaunch = currentCargo / cargoLimit * 0.05
    override val chanceToExplodeOnLand = currentCargo / cargoLimit * 0.01
    override fun launch(): Boolean  = (1..100).random() > chanceToExplodeOnLaunch * 100
    override fun land(): Boolean = (1..100).random() > chanceToExplodeOnLand * 100
}