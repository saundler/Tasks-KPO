import java.util.Random;
import java.util.Scanner;

public class Programm {
    public static void main(String[] args) {
        PetContainer<Pet> pets = new PetContainer();
        Random random = new Random();
        int n = random.nextInt(0, 7);
        for (int i = 0; i < n; ++i) {
            pets.putIntoContainer(new Dog("CAT"));
            pets.putIntoContainer(new Cat("DOG"));
        }
        Pet pet = pets.hearVoice();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите 0, если это была собака, если кошка то 1: ");
        n = scanner.nextInt();
        if ((n == 0 && pet instanceof Dog) || (n == 1 && pet instanceof Cat)) {
            System.out.println("Верно!!!");
        } else {
            System.out.println("Неверно!!!");
        }
        Veterinarian<? super Pet> vet = new Veterinarian<>();
        if (vet.getPetHealth(pet)){
            System.out.print("Питомец здоров!!!");
        } else {
            System.out.print("Питомец болен!!!");
        }
    }
}
