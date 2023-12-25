import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;


public class JsonUtil {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    public static String serializeObject(Object object) {
        return GSON.toJson(object);
    }

    // Метод для сериализации объекта Cinema в JSON и сохранения в файл
    public static void saveCinemaToFile(Cinema cinema, String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(serializeObject(cinema));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Метод для десериализации объекта Cinema из файла JSON
    public static Cinema loadCinemaFromFile(String filePath) {
        try (Reader reader = new FileReader(filePath)) {
            return GSON.fromJson(reader, Cinema.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    public static void saveUserToFile(User user, String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(serializeObject(user));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Метод для десериализации объекта User из файла JSON
    public static User loadUserFromFile(String filePath) {
        try (Reader reader = new FileReader(filePath)) {
            return GSON.fromJson(reader, User.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
