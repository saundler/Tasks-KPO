package vendingMachineTaskJava;

public class BuyCoffeeButton {

    private CoinState coins;
    private int price = 2;

    public BuyCoffeeButton(CoinState state) {
        coins = state;
    }

    public void buy() {
        if (coins.hasEnoughCoins(price))
            System.out.println("Preparing coffee...");
        else
            System.out.println("Not enough to buy coffee...");
        coins.notify(this);
    }
}
