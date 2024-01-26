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

    public void notify (Object button){
        String classType = button.getClass().getName();
        switch (classType) {
            case "BuyCoffeButton":
                System.out.println("You bought coffe");
                break;
            case "BuyTeaButton":
                System.out.println("You bought tea");
                break;
            case "ReturnCoinButton":
                System.out.println("You got your money back");
                break;
        }
    }
}
