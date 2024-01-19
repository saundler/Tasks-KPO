public class Main {
    public static void main(String[] args) {
        ProxyShopDatabase psd = new ProxyShopDatabase();
        psd.addProduct("product");
        psd.getProduct(0);
        psd.deleteProduct(0);
        psd.secretcode = "secretAdmin";
        psd.addProduct("product");
        psd.getProduct(0);
        psd.deleteProduct(0);
    }
}
