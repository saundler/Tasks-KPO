import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CollectionsTasks {

    /**
     *  Задание 1: Заменить все повторяющиеся элементы входного списка на "blahblah".
     *  (1 балл)
     */
    public static List<String> replaceElements(List<String> array) {
        String replacement = "blahblah";
        Set<String> uniqueElements = new HashSet<>();
        List<String> result = new ArrayList<>();
        for (String element : array) {
            if (uniqueElements.contains(element)) {
                result.add(replacement);
            } else {
                uniqueElements.add(element);
                result.add(element);
            }
        }
        return result;
    }

    /**
     *  Задание 2: Вернуть количество уникальных слов в строке.
     *  Слова в строке обязательно разделяются пробелом.
     *  (1 балл)
     */
    public static int uniqueWords(String text) {
        if(text == "") {
            return 0;
        }
        String[] words = text.split("\\s+");
        Set<String> uniqueWords = new HashSet<>();
        int count = 0;
        for (String word : words) {
            if (!uniqueWords.contains(word)) {
                uniqueWords.add(word);
                ++count;
            }
        }
        return count;
    }

    public static void main(String[] args) {
         String text = "a bb a";
         System.out.println(uniqueWords(text));
         List<String> list = new ArrayList<String>();
         list.add("sds");
         list.add("dds");
         list.add("sds");
         list = replaceElements(list);
         for (String str : list) {
             System.out.println(str);
         }
    }
}
