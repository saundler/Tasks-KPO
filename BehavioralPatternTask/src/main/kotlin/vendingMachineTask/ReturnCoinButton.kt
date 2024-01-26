package vendingMachineTask


class ReturnCoinButton(private val coins: CoinsState) {

    public fun returnCoins() {
        if (coins.hasEnoughCoins(1))
            println("Returning all coins...")
        else
            println("Machine has no coins to return...")
    }

}