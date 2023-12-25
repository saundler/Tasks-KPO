import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class User {
    User() {
    }

    public void buyTicket(Cinema cinema) {
        if (cinema.sessions.isEmpty()) {
            System.out.println("\u001B[31m" + "Нельзя купить билет так как список сеансов пуст" + "\u001B[0m");
            return;
        }
        System.out.println("\u001B[44m" + "Покупка билета" + "\u001B[0m");
        Scanner scanner = new Scanner(System.in);
        Session session;
        do {
            session = cinema.selectSession();
            if (session == null) {
                return;
            }
            if (session.end.isBefore(LocalTime.now())) {
                session = null;
                System.out.println("\u001B[31m" + "Нельзя купить билет на уже завершившейся сеанс" + "\u001B[0m");
            }
        } while (session == null);
        session.outputPlaces();
        int placeNumber = 0;
        do {
            if (continueOrNot()) {
                return;
            }
            try {
                System.out.print("\u001B[34m" + "Выберите место:" + "\u001B[0m");
                placeNumber = Integer.parseInt(scanner.next());
                if (placeNumber < 1 || placeNumber > session.places.length) {
                    System.out.println("\u001B[31m" + "Не существует места с таким номером" + "\u001B[0m");
                    placeNumber = 0;
                } else if (session.places[placeNumber - 1]) {
                    System.out.println("\u001B[31m" + "Данное место уже занято" + "\u001B[0m");
                    placeNumber = 0;
                }
            } catch (java.lang.NumberFormatException exception) {
                System.out.println("\u001B[31m" + "Неккоректный ввод числа, повторите попытку" + "\u001B[0m");
            }
        } while (placeNumber == 0);
        cinema.tickets.add(new Ticket(session.movie.name, session.start, placeNumber));
        session.places[placeNumber - 1] = true;
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void outputTickets(Cinema cinema) {
        System.out.println("\u001B[34m" + "Список купленных билетов:" + "\u001B[0m");
        for (int i = 0; i < cinema.tickets.size(); ++i) {
            System.out.printf("[%d]" + cinema.tickets.get(i).toString() + "\n", i + 1);
        }
    }

    public void returnTicket(Cinema cinema) {
        if (cinema.tickets.isEmpty()) {
            System.out.println("\u001B[31m" + "Нельзя вернуть билет так как список билетов пуст" + "\u001B[0m");
            return;
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("\u001B[44m" + "Возврат билета" + "\u001B[0m");
        outputTickets(cinema);
        int ticketNumber = 0;
        do {
            if (continueOrNot()) {
                return;
            }
            try {
                System.out.print("\u001B[34m" + "Выберите билет: " + "\u001B[0m");
                ticketNumber = Integer.parseInt(scanner.next());
                if (ticketNumber < 1 || ticketNumber > cinema.tickets.size()) {
                    System.out.println("\u001B[31m" + "Не существует билета с таким номером" + "\u001B[0m");
                    ticketNumber = 0;
                } else if (cinema.tickets.get(ticketNumber - 1).sessionStart.isBefore(LocalTime.now())) {
                    System.out.println("\u001B[31m" + "Нельзя вернуть билет на уже начавшийся сеанс" + "\u001B[0m");
                    ticketNumber = 0;
                }
            } catch (java.lang.NumberFormatException exception) {
                System.out.println("\u001B[31m" + "Неккоректный ввод числа, повторите попытку" + "\u001B[0m");
            }
        } while (ticketNumber == 0);
        Ticket ticket = cinema.tickets.get(ticketNumber - 1);
        Session session = cinema.sessions.stream().filter(curSession -> curSession.movie.name.equals(ticket.movieName) && curSession.start.equals(ticket.sessionStart)).findAny().orElse(null);
        session.places[ticket.placeNumber - 1] = false;
        cinema.tickets.remove(ticket);
    }

    private boolean continueOrNot() {
        Scanner scanner = new Scanner(System.in);
        String command;
        do {
            System.out.print("\u001B[34m" + "Для выхода в главное меню введите \"exit\", чтобы продолжить введите \"continue\": " + "\u001B[0m");
            command = scanner.next();
            if (command.equals("exit")) {
                return true;
            } else if (!command.equals("continue")) {
                System.out.println("\u001B[31m" + "Данная команда не существует, повторите ввод" + "\u001B[0m");
            }
        } while (!command.equals("continue"));
        return false;
    }
}
