import java.util.Objects;

public class ProxyShopDatabase implements Database {
    ShopDatabase shopDatabase;
    String secretcode;

    public ProxyShopDatabase() {
        this.secretcode = "notAdmin";
    }
    public ProxyShopDatabase(String secretcode) {
        this.secretcode = secretcode;
    }

    @Override
    public String getProduct(int index) {
        if(shopDatabase == null){
            shopDatabase = new ShopDatabase();
        }
        if(secretcode.equals("secretAdmin")) {
            System.out.println("Поиск товара под номером  " + index + ", выполненно владельцем магазина");
        } else {
            System.out.println("Поиск товара под номером " + index + ", выполненно не владельцем магазина");
        }
        return shopDatabase.getProduct(index);
    }

    @Override
    public void addProduct(String product) {
        if (shopDatabase == null){
            shopDatabase = new ShopDatabase();
        }
        if (secretcode.equals("secretAdmin")) {
            shopDatabase.addProduct(product);
            System.out.println("Товар " + product + " добавленн в базу данных, выполненно владельцем магазина");
        } else {
            System.out.println("Отказано в доступе, вы не владелец магазина");
        }
    }

    @Override
    public void deleteProduct(int index) {
        if (shopDatabase == null){
            shopDatabase = new ShopDatabase();
        }
        if (Objects.equals(secretcode, "secretAdmin")) {
            shopDatabase.deleteProduct(index);
            System.out.println("Товар под номером " + index + " удален из базы данных, выполненно владельцем магазина");
        } else {
            System.out.println("Отказано в доступе, вы не владелец магазина");
        }
    }
}
