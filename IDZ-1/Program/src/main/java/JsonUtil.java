import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.time.LocalTime;


public class JsonUtil {
    private static final Gson GSON = new GsonBuilder().registerTypeAdapter(LocalTime.class, new LocalTimeAdapter()).setPrettyPrinting().create();

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
}
