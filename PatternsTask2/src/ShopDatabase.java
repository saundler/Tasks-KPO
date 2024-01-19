import java.util.ArrayList;

public class ShopDatabase implements Database{
    ArrayList<String> products = new ArrayList<>();
    @Override
    public String getProduct(int index) {
        if (products.size() <= index) {
            System.out.println("В базе данных нет элемента с таким номером");
            return null;
        }
        System.out.println("Товар найден");
        return products.get(index);
    }
    @Override
    public void addProduct(String product) {
        products.add(product);
    }
    @Override
    public void deleteProduct(int index) {
        if (products.size() <= index) {
            System.out.println("В базе данных нет элемента с таким номером");
        }
        products.remove(index);
    }
}
