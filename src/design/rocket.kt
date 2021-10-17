package design

class Rocket : Spaceship {
    override fun launch(): Boolean {
        return true
    }
    override fun land(): Boolean {
        return true
    }
    override fun canCarry(item: Item): Boolean {
        return true
    }
    override fun carry(item: Item): Int {
        return 10
    }
}

interface Spaceship {
    fun launch(): Boolean
    fun land(): Boolean
    fun canCarry(item: Item) : Boolean
    fun carry(item: Item) : Int
}