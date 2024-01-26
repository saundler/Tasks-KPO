package vendingMachineTaskJava;

public class CoinState {
    private int coins = 0;

    public void insertCoin(int value) {
        coins += value;
    }

    public boolean hasEnoughCoins(int amount) {
        boolean response = coins >= amount;
        coins -= amount;
        return response;
    }

}
