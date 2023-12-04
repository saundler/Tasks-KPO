package seminar7;

import java.util.Arrays;
import java.util.Collection;

public class Main {
    public static void main(String[] args) {
        String neg = "abcdefghijklmnopqrstuvwxyz";
        MyFilterInterface ref = (str) -> {
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < str.length(); i++) {
                if (!neg.contains(String.valueOf(str.charAt(i)))) {
                    result.append(str.charAt(i));
                }
            }
            return result.toString();
        };
        GenericInterface<Collection<Integer>> ref2 = (collection) -> {
            StringBuilder res = new StringBuilder();
            for (int i : collection) {
                res.append(i).append(", "); // Add a comma and space as a separator
            }
            return res.toString();
        };
        System.out.println(ref.removeNegCharacters("Lambda123lambda"));
        System.out.println(ref2.join(Arrays.asList(1, 4, 6)));
    }
}
