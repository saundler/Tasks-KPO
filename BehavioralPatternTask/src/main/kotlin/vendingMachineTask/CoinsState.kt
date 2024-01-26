package vendingMachineTask

class CoinsState(private var coins: Int = 0) {
    public fun insertCoin(value: Int) {
        coins += value;
    }

    public fun hasEnoughCoins(amount: Int): Boolean {
        val response = coins >= amount
        coins -= amount;
        return response
    }

}