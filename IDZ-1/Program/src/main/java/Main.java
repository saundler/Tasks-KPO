import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        User user = new User();
        Cinema cinema = null;
        try {
            cinema = JsonUtil.loadCinemaFromFile("data/cinema.txt");
        } catch (Exception exception) {
            cinema = null;
        }
        if (cinema == null) {
            boolean flag;
            int placesNumbers = 1;
            Scanner scanner = new Scanner(System.in);
            do {
                flag = false;
                System.out.print("\u001B[34mВведите количесвто мест в зале: \u001B[0m");
                try {
                    placesNumbers = Integer.parseInt(scanner.next());
                    if (placesNumbers < 1) {
                        System.out.println("\u001B[31mКоличество мест не может быть меньше 1\u001B[0m");
                        flag = true;
                    }
                } catch (java.lang.NumberFormatException e) {
                    System.out.println("\u001B[31mНеккоректный ввод числа, повторите попытку\u001B[0m");
                    flag = true;
                }
            } while (flag);
            cinema = new Cinema(placesNumbers);
        }
        Scanner scanner = new Scanner(System.in);
        String command;
        do {
            System.out.println("\u001B[44m" + "Главное меню" + "\u001B[0m");
            System.out.println(
                    "\u001B[34madd movie\u001B[0m      - Добавить фильм\n" +
                            "\u001B[34madd session\u001B[0m    - Добавить сеанс\n" +
                            "\u001B[34mdelete session\u001B[0m - Удалить сеанс\n" +
                            "\u001B[34mdelete movie\u001B[0m   - Удалить фильм\n" +
                            "\u001B[34mbuy ticket\u001B[0m     - Купить билет\n" +
                            "\u001B[34mreturn ticket\u001B[0m  - Вернуть билет\n" +
                            "\u001B[34mview places\u001B[0m    - Просмотр мест\n" +
                            "\u001B[34mexit\u001B[0m           - Завершение работы программы");
            System.out.print(("\u001B[34m" + "Введите команду: " + "\u001B[0m"));
            command = scanner.nextLine();
            switch (command) {
                case "add movie":
                    cinema.addMovie();
                    break;
                case "add session":
                    cinema.addSession();
                    break;
                case "delete session":
                    cinema.deleteSession();
                    break;
                case "delete movie":
                    cinema.deleteMovie();
                    break;
                case "buy ticket":
                    user.buyTicket(cinema);
                    break;
                case "return ticket":
                    user.returnTicket(cinema);
                    break;
                case "view places":
                    cinema.viewPlaces();
                    break;
                case "exit":
                    break;
                default:
                    System.out.println(("\u001B[31m" + "Данная команда не существует, повторите ввод" + "\u001B[0m"));
            }
        } while (!command.equals("exit"));
        JsonUtil.saveCinemaToFile(cinema, "data/cinema.txt");
    }
}