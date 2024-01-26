package vendingMachineTaskJava;

public class CoinSlot {
    private CoinState coins;

    public CoinSlot(CoinState state) {
        coins = state;
    }

    public void insertCoin(int value) {
        System.out.println("Customer tries to insert coint...");
        coins.insertCoin(value);
        System.out.println("Coin has been accepted...");
    }
}
