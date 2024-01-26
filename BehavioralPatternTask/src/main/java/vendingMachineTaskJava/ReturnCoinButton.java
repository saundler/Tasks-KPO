package vendingMachineTaskJava;

public class ReturnCoinButton {
    private CoinState coins;

    public ReturnCoinButton(CoinState state) {
        coins = state;
    }

    public void returnCoins() {
        if (coins.hasEnoughCoins(1))
            System.out.println("Returning all coins...");
        else
            System.out.println("Machine has no coins to return...");
        coins.notify(this);
    }

}
