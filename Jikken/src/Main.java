import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long a;
        for (int i = 0; i < 12; ++i) {
            try {
                a = Long.parseLong(scanner.nextLine());
            } catch (java.lang.NumberFormatException e) {
                System.out.println(e);
                //scanner.nextLong();
            }
            System.out.println(i);
        }


    }
}