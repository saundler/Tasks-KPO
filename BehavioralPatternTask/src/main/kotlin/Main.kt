import vendingMachineTask.*

fun main(args: Array<String>) {

    // TODO: A collection of classes represents a vending machine.
    // Vending machine sells tea for 1 coin and coffee for 2 coins
    // Customer can:
    // - insert coins in CoinSlot
    // - select beverage with specific button
    // - refund his coins (if there are any)

    // TODO: There are several problems
    // - CoinSlot, coffeeButton, teaButton all have direct references to CoinsState
    // - BuyCoffeeButton, BuyTeaButton have similar copy-pasted logic. Would be better to unify them
    //
    // Restrictions:
    // - Classes BuyCoffeeButton, BuyTeaButton, ReturnCoinButton and CoinSlot
    //   must not be deleted or renamed

    // TODO: Apply Mediator pattern or discuss why the other might be better


    val state = CoinsState()
    val coinSlot = CoinSlot(state);
    val buyCoffeeButton = BuyCoffeeButton(state)
    val buyTeaButton = BuyTeaButton(state)
    val returnCoinButton = ReturnCoinButton(state)

    coinSlot.insertCoin(3)
    buyCoffeeButton.buy()
    returnCoinButton.returnCoins()
    coinSlot.insertCoin(1)
    buyTeaButton.buy()
    returnCoinButton.returnCoins()

}