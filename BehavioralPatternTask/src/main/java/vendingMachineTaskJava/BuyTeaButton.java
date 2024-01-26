package vendingMachineTaskJava;

public class BuyTeaButton {
    private CoinState coins;
    private int price = 1;

    public BuyTeaButton(CoinState state) {
        coins = state;
    }

    public void buy() {
        if (coins.hasEnoughCoins(price))
            System.out.println("Preparing tea...");
        else
            System.out.println("Not enough to buy tea...");
        coins.notify(this);
    }
}
