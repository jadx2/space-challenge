package design

interface Spaceship {
    fun launch(): Boolean
    fun land(): Boolean
    fun canCarry(item: Item ) : Boolean
    fun carry(item: Item) : Int
}
