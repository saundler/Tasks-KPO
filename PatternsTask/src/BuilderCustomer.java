public class BuilderCustomer implements Builder {
    private User user;
    @Override
    public void giveRole() {
        user.role = Role.Customer;
    }

    @Override
    public void giveName() {
        user.name = "Customer";
    }

    @Override
    public void giveImageURL() {}

    @Override
    public void giveStoreName() {}

    @Override
    public void giveMaxNumberItems() {}

    @Override
    public void giveCreditcardNumber() {
        user.creditCardNumber = 1234567890;
    }
}
