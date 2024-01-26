package vendingMachineTask

class BuyCoffeeButton(private val coins: CoinsState, val price: Int = 2) {

    fun buy() {
        if (coins.hasEnoughCoins(price))
            println("Preparing coffee...")
        else
            println("Not enough to buy coffee...")
    }
}