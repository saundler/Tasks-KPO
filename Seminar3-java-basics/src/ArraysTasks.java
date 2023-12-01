import java.util.Scanner;

public class ArraysTasks {

    /**
     Задание 1: Сформировать целочисленный массив A из N элементов
     при помощи ввода значений с клавиатуры (N вводит пользователь).
     Вывести массив на экран. (1 балл)
     */
    public static int[] makeArray() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите длинну массива:");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        String message;
        for (int i = 0; i < n; ++i) {
            message = String.format("Введите значени %d - го элемента", i);
            System.out.println(message);
            arr[i] = scanner.nextInt();
        }
        return arr;
    }

    /**
     Задание 2: Написать функцию для сортировки массива по убыванию и его вывода на экран.
     Использовать встроенные функции. (0.5 балла)
     */
    public static void sortArrayDesc(int[] arr) {
        for (int i = 0; i < arr.length; ++i) {
            for (int j = i; j < arr.length; ++j) {
                if (arr[i] > arr[j]) {
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
        System.out.println("Отсортированный массив:");
        for (int elem : arr) {
            System.out.print(elem + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr = makeArray();
        sortArrayDesc(arr);
    }
}
