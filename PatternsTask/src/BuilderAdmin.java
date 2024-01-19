public class BuilderAdmin implements Builder{
    private User user;
    @Override
    public void giveRole() {
        user.role = Role.Admin;
    }

    @Override
    public void giveName() {}

    @Override
    public void giveImageURL() {}

    @Override
    public void giveStoreName() {}

    @Override
    public void giveMaxNumberItems() {

    }

    @Override
    public void giveCreditcardNumber() {

    }
}
