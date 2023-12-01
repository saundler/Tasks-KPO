import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class PetContainer<T> {
    private final List<T> Pets;
    public PetContainer() {
        Pets = new ArrayList<>();
    }
    public void putIntoContainer(T pet) {
        Pets.add(pet);
    }
    public T hearVoice() {
        T randomPet = Pets.get(new Random().nextInt(Pets.size()));
        System.out.println("А pet's voice came through the container: " + randomPet + ". Can you guess who this is?");
        return randomPet;
    }
}
