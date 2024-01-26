package vendingMachineTask

class CoinSlot (private val coins: CoinsState) {

    public fun insertCoin(value: Int) {
        println("Customer tries to insert coint...")
        coins.insertCoin(value)
        println("Coin has been accepted...")
    }
}