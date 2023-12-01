import java.util.Scanner;

public class BaseTasks {

    /**
     Задание 1: Функция,спрашивающая у пользователя его ФИО и выводящая его на экране.
     (0.5 балла)
     Формат вывода:
     " Фамилия:
     Имя:
     Отчество:
     "
     */
    public static void askForInput() {
        System.out.print("Введите свое ФИО: ");
        Scanner scanner = new Scanner(System.in);
        String[] data = scanner.nextLine().split(" ");
        System.out.println("Фамилия: " + data[0]);
        System.out.println("Имя: " + data[1]);
        System.out.println("Отчество: " + data[2]);
    }

    /**
     Задание 2: Функция, вычисляющая и возвращающая корни квадратного уравнения. (1 балл)
     */
    public static double[] quadraticRoots(double a, double b, double c) {
        double d = b * b - 4 * a * c;
        double[] ans = new double[2];
        ans[0] = (-b - Math.sqrt(d)) / (2 * a);
        ans[1] = (-b + Math.sqrt(d)) / (2 * a);
        return ans;
    }

    /**
     Задание 3: Вывести на экран трёхзначные десятичные числа s, все цифры которых одинаковы.
     (2 балла)
     */
    public static void printSameDigitNumbers() {
        int tmp;
        for (int i = 1; i < 10; ++i) {
            tmp = i * 100 + i * 10 + i;
            System.out.println(tmp);
            System.out.println(tmp * -1);
        }
    }

    public static void main(String[] args) {
         askForInput();

        double[] roots = quadraticRoots(-5.0, 4.0, 3.0);
        System.out.println("X1 = " + roots[0] + " ; X2 = " + roots[1]);

        printSameDigitNumbers();
    }
}
