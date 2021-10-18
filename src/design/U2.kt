package design

class U2(private val launchSuccess: Int, private val landSuccess: Int): Rocket() {
    override val cost = 120000000
    override val weight = 18000
    override var currentCargo = 0
    override val cargoLimit = 11000
    override val chanceToLaunch = currentCargo / cargoLimit * 0.04
    override val chanceToLand = currentCargo / cargoLimit * 0.08

    override fun launch(): Boolean = chanceToLaunch < launchSuccess
    override fun land(): Boolean = chanceToLand < landSuccess
    override fun canCarry(item: Item): Boolean = item.weight + currentCargo < cargoLimit
    override fun carry(item: Item): Int = currentCargo + item.weight
}