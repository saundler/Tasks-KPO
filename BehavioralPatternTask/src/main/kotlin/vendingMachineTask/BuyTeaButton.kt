package vendingMachineTask

class BuyTeaButton(private val coins: CoinsState, val price: Int = 1) {

    fun buy() {
        if (coins.hasEnoughCoins(price))
            println("Preparing tea...")
        else
            println("Not enough to buy tea...")
    }
}