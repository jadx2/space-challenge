package design

class U1(private val launchSuccess: Int, private val landSuccess: Int) : Rocket() {
    override val cost = 100000000
    override val weight = 10000
    override var currentCargo = 0
    override val cargoLimit = 8000
    override val chanceToLaunch = currentCargo / cargoLimit * 0.05
    override val chanceToLand = currentCargo / cargoLimit * 0.01

    override fun launch(): Boolean = chanceToLaunch < launchSuccess
    override fun land(): Boolean = chanceToLand < landSuccess
    override fun canCarry(item: Item): Boolean =item.weight + currentCargo < cargoLimit
    override fun carry(item: Item): Int = currentCargo + item.weight
}