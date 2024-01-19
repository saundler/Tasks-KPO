public class BuilderSeller implements Builder {
    private User user;
    @Override
    public void giveRole() {
        user.role = Role.Seller;
    }

    @Override
    public void giveName() {
        user.name = "Seller";
    }

    @Override
    public void giveImageURL() {
        user.ImageURL = "URL";
    }

    @Override
    public void giveStoreName() {
        user.storeName = "Magazin";
    }

    @Override
    public void giveMaxNumberItems() {
        user.maxNumberItems = 200;
    }

    @Override
    public void giveCreditcardNumber() {}
}
