import java.util.Random;

public class Veterinarian<T extends Pet> {
    public Veterinarian() {}
    public boolean getPetHealth(T pet) {
        Random random = new Random();
        return random.nextBoolean();
    }
}
