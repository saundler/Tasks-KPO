import dependency_inversion.bad.src.Emailer;
import dependency_inversion.bad.src.Phone;
import dependency_inversion.bad.src.WeatherTracker;
import interface_segregation.bad.src.Eagle;
import interface_segregation.bad.src.Penguin;
import open_closed.bad.src.Greeter;


public class Main {
    public static void main(String[] args) {
        // ЗАДАНИЕ 1: Приветствие
        Greeter greeting = new Greeter();
        greeting.setFormality("formal");
        if (!greeting.greet().equals("Good evening, sir.")) {
            throw new IllegalStateException("Wrong message intro");
        }

        // ЗАДАНИЕ 2: Уведомления о погоде
        WeatherTracker tracker = new WeatherTracker(new Phone(), new Emailer(), "sunny");

        // let's get a phone notification
        tracker.setCurrentConditions("rainy");

        // ЗАДАНИЕ 3: Птицы бывают разные (но не все всё умеют)
        Eagle eagle = new Eagle(150);
        eagle.fly();

        Penguin penguin = new Penguin(0);

        // Пингвин не хочет чувствовать себя ущербным:(
        // А мы не хотим видеть исключения в коде...
        penguin.fly();
    }
}
